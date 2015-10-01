package org.jgrapetree.model.form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jgrapetree.model.Form;
import org.jgrapetree.model.Widget;

/**
 * @author zhanglei
 * A document can add/del/query nodes.
 */
public class GrapeWidgetManager implements Cloneable, Form{
	private String uid;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	private Widget rootWidget;
	private Map<String, Widget> nodeMap = Collections.synchronizedMap(new HashMap());
	
	//
	public Widget getRoot() {
		return rootWidget;
	}
	public void setRoot(Widget root) {
		this.rootWidget = root;
	}
	public Widget createWidget(){
		return new GrapeWidget();		
	}
	private boolean addOneWidget(Widget node){
		if(hasWidget(node))return false;		
		if(nodeMap.isEmpty()){
			setRoot(node);
		}
		nodeMap.put(node.getUid(), node);
		return true;
	}
	public boolean addWidget(Widget node){
		boolean succ = addOneWidget(node);
		for(Widget n: node.getChildren()){
			succ = succ && addWidget(n);
		}
		return succ;
	}
	public boolean copyWidget(String copyUid, String pasteUid){
		Widget copyWidget = this.getWidget(copyUid);
		Widget pasteWidget = this.getWidget(pasteUid);
		if(copyWidget != null && pasteWidget != null){
			Widget newWidget = copyWidget.clone();
			pasteWidget.addChild(newWidget);
			this.addWidget(newWidget);
			return true;
		}
		return false;
	}
	public Widget getWidget(String uid){
		return nodeMap.get(uid);
	}
	public boolean hasWidget(Widget node){
		return hasWidget(node.getUid());
	}
	
	public boolean hasWidget(String uid){
		return nodeMap.containsKey(uid);
	}
	public void delWidget(String uid){
		_delWidget(getWidget(uid));	
	}
	public void delWidget(Widget node){
		_delWidget(node);
	}
	private void _delWidget(Widget node){
		/**
		for(Node n: node.getChildren()){
			_delNode(n);
		}
		nodeMap.remove(node.getUid());
		Node parent = node.getParent();
		if(parent != null){
			parent.removeChild(node);
		}
		node.killSelf();
		node = null;**/
		nodeMap.remove(node.getUid());
		Widget parent = node.getParent();
		if(parent != null){
			parent.removeChild(node);
		}
		node.killSelf();
		node = null;
	}
	public Form clone(){
		return null;
	}
	//
	private void cacheOneWidget(Widget node){
		nodeMap.put(node.getUid(), node);
	}
	private void cacheWidget(Widget node){
		cacheOneWidget(node);
		for(Widget n: node.getChildren()){			
			cacheWidget(n);
		}
	}
	//
	public List<Widget> getAllWidgets(){
		ArrayList<Widget> list = new ArrayList<Widget>();
		Iterator iterator = nodeMap.keySet().iterator();            
        while (iterator.hasNext()) {
        	Object key = iterator.next();
        	list.add(nodeMap.get(key));
        }       
		return list;
	}
}
