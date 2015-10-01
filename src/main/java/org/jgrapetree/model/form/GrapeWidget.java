package org.jgrapetree.model.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.jgrapetree.model.Widget;
import org.jgrapetree.model.atom.HtmlManagement;
import org.jgrapetree.util.MathUtil;

import com.rits.cloning.Cloner;
/*
 * Node focus on hierarchical relation
 * 
 */
public class GrapeWidget extends HtmlManagement implements Cloneable, Widget{
	
	protected String uid = null;//Universally Unique Identifier	
	
	private Widget myParent;
	//
	private Map<String, Widget> childrenMap;//HashMap<String, Node> uidMap = new HashMap();
	private ArrayList<Widget> childrenList;//ArrayList<Node> children = new ArrayList();
	//
	
	public GrapeWidget(){
		this.generateUid();
		this.resetChildren();
	}
	
	//
	public String getUid() {
		return this.uid;
	}
	protected void generateUid(){
		if(this.uid == null){
			MathUtil mu = new MathUtil();
			this.uid =  "n" + mu.getHexStr();
		}		
	}
	protected void reGenerateUid(){//only for clone!!
		this.uid = null;
		generateUid();
	}
	
	//-------
	public boolean hasParent() {
		return getParent() != null;
	}
	public Widget getParent() {
		return this.myParent;
	}
	public void setParent(Widget parent) {
		this.myParent = parent;
	}
	public void resetParent(){
		this.myParent = null;
	}
	public List<Widget> getParents(){
		List parents = new ArrayList();
		Widget p = this.getParent();
		while(p != null){
			parents.add(p);
			p = p.getParent();			
		}
		return parents;
	}
	//-------
	public boolean hasChild(){
		return this.getChildren().size() > 0;
	}
	public boolean hasChild(String uid){
		return this.childrenMap.containsKey(uid);
	}
	public boolean hasChild(Widget node){
		return childrenMap.containsValue(node);
	}
	public void cutoffRelation(Widget node){
		//cutoff relation with this node
		this.childrenList.remove(node);
		this.childrenList.trimToSize();
		this.childrenMap.remove(node.getUid());
	}
	//delete here means cutoff releation
	//do not kill, NOT actrul set to null, that's the document's job
	public void removeChild(Widget node) {
		if(node == null) return;
		cutoffRelation(node);
	}
	private void removeChild(int i){//DANGER! Do NOT public function delChild(index), because index will change after delete!
		Widget node = this.getChild(i);
		if(node != null)removeChild(node);
	}
	public void removeChildren(){
		for(int i = 0; i < this.getChildrenSize(); i++){
			removeChild(0);//index of the list will reduce 1 to if deleted one node.
		}
		this.resetChildren();
	}
	public void addChild(Widget node) {
		if(this.hasChild(node))return;
		this.childrenList.add(node);
		this.childrenList.trimToSize();
		this.childrenMap.put(node.getUid(), node);
		node.setParent(this);
	}
	public void addChild(int index, Widget node) {
		this.childrenList.add(index, node);
		this.childrenList.trimToSize();
		this.childrenMap.put(node.getUid(), node);
		node.setParent(this);
	}
	public int getSequenceNumber(){
		Widget parent = this.getParent();
		if(parent != null){
			return parent.getSequenceNumber(this);
		}else{
			return -1;//no parent, should NOT be 0
		}		
	}
	public int getSequenceNumber(Widget node){
		return this.getChildren().indexOf(node);
	}
	public int getSequenceNumber(String uid){
		if (this.getChildren().size() > 0) {
			Widget node = this.getChild(uid);
			return getSequenceNumber(node);
		}
		return -1;
	}
	public int getChildIndex(String uid){
		Object obj = this.getChild(uid);
		if(obj!=null){
			return this.getChildren().indexOf((Widget)obj);
		}else{
			return -1;
		}
	}
	public int getChildIndex(Widget node){
		return getChildIndex(node.getUid());
	}
	public Widget getChild(int index){		
		return this.getChildren().get(index);
	}
	public Widget getChild(String uid){
		return this.childrenMap.get(uid);
	}
	public Widget getFirstChild(){
		return getChild(0);
	}
	public Widget getLastChild(){
		if(this.getChildrenSize() == 0)return null;
		return this.getChild(this.getChildrenSize() - 1);		
	}
	public List<Widget> getChildren() {
		return this.childrenList;
	}
	public int getChildrenSize() {
		return this.childrenList.size();
	}
	public void resetChildren() {
		this.childrenList = new ArrayList();
		this.childrenMap = Collections.synchronizedMap(new HashMap());
	}
	//move to
	public void moveUp(){
		int index = this.getSequenceNumber();
		Widget p = this.getParent();
		if(p == null) return;
		this.moveTo(index - 1, p);
	}
	public void moveDown(){
		int index = this.getSequenceNumber();
		Widget p = this.getParent();
		if(p == null) return;
		this.moveTo(index + 1, p);
	}
	public void moveTo(Widget newParent){
		this.moveTo(newParent.getChildrenSize(), newParent);
	}
	public void moveTo(int idx, Widget newParent){
		Widget oldParent = this.getParent();
		//position checking
		if(newParent.hasChild(this)){
			//if((idx-1) >= this.getSequenceNumber())idx = newParent.();//return;//already is the last one
		}
		if(isIncest(newParent)){
			return;//incase of drop parent to children
		}
		//range
		if(idx < 0)return;
		//cutoff
		if(oldParent != null){
			oldParent.cutoffRelation(this);
		}
		if(idx > newParent.getChildrenSize())idx = newParent.getChildrenSize();
		newParent.addChild(idx, this);
	}
	private boolean isIncest(Widget widget){
		Widget p = widget.getParent();
		while(p != null){
			if(this.getUid().equals(p.getUid()))return true;
			p = p.getParent();
		}
		return false;
	}
	public void moveToFirst(Widget newParent){
		moveTo(0, newParent);
	}
	public void moveToLast(Widget newParent){
		moveTo(newParent);
	}
	public boolean moveBefore(Widget brother){
		boolean succ = false;
		Widget newParent = brother.getParent();
		if(newParent != null){
			int idx = newParent.getSequenceNumber(brother);
			moveTo(idx, newParent);
			succ = true;
		}
		return succ;
	}
	public boolean moveAfter(Widget brother){
		boolean succ = false;
		Widget newParent = brother.getParent();
		if(newParent != null){
			int idx = newParent.getSequenceNumber(brother);			
			moveTo(idx + 1, newParent);
			succ = true;
		}
		return succ;
	}
	//
	public GrapeWidget clone(){
		Cloner cloner = new Cloner();
		GrapeWidget newnode = cloner.deepClone(this);
		newnode.afterClone();		
		return newnode;
	}
	public void afterClone(){
		this.reGenerateUid();
		for(Widget n: this.getChildren()){
			n.setParent(this);
			n.afterClone();			
		}
	}
	/**
	public Widget clone(){
		try {
			Widget newNode = this.cloneSelf();
			newNode.reGenerateUid();
			cloneChild(newNode);
			return newNode;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	public Widget cloneSelf() throws CloneNotSupportedException{
			Widget cloneNode = (Widget) super.clone();
			cloneNode.reGenerateUid();
			return cloneNode;
	}
	private void cloneChild(Widget node) throws CloneNotSupportedException{
		List<Widget> list = new ArrayList();
		for(Widget n: node.getChildren()){
			Widget newChild = n.cloneSelf();
			list.add(newChild);
			//cloneChild(n);
		}
		node.resetChildren();
		for(Widget n: list){
			node.addChild(n);	
		}
		
	}**/
	//
	public void reset(){
		this.resetAttr();
		this.resetChildren();
		this.resetParent();
	}
	public void killSelf(){
		//for(Widget n: this.getChildren()){
		//	n.kill();
		//}
		this.killAttr();
		this.myParent = null;
		this.childrenList = null;
		this.childrenMap = null;
	}
}
