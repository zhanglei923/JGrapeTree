package org.jgrapetree.model;

import java.util.List;
import java.util.Map;

import org.jgrapetree.model.form.GrapeWidget;

public interface Widget {
	public String getUid();
	public String getType();
	//
	public String attr(String attrName);
	public int intAttr(String attrName);
	public float floatAttr(String attrName);
	//
	public void setAttr(String attrName, Object attrValue);
	public Object getAttr(String attrName);
	public String getAttrAsStr(String attrName);
	public Integer getAttrAsInt(String attrName);
	public Float getAttrAsFloat(String attrName);
	public boolean hasAttr(String attrName);
	public boolean hasAttr(String attrName, String attrValue);
	public boolean hasAttr(String attrName, int attrValue);
	public void delAttr(String attrName);
	public void renameAttr(String oldName, String newName);
	public Map<String, Object> getAttributes();
	public void resetAttr();
	//
	public void setParent(Widget parent);
	public Widget getParent();
	public boolean hasParent();
	public List getParents();
	//
	public void addChild(int index, Widget IWidget);
	public void addChild(Widget IWidget);	
	public Widget getChild(int index);
	public Widget getChild(String uid);
	public Widget getFirstChild();
	public Widget getLastChild();
	public void removeChild(Widget child);
	public void removeChildren();
	public List<Widget> getChildren();
	public int getChildrenSize();
	public boolean hasChild();
	public boolean hasChild(String uid);
	public boolean hasChild(Widget node);
	
	//
	public void moveTo(Widget newParent);
	public void moveTo(int idx, Widget newParent);
	public void moveToFirst(Widget newParent);
	public void moveToLast(Widget newParent);
	public boolean moveBefore(Widget IWidget);
	public boolean moveAfter(Widget IWidget);
	public void moveUp();
	public void moveDown();
	public void cutoffRelation(Widget IWidget);
	//
	public int getSequenceNumber(Widget node);
	public int getSequenceNumber(String uid);
	public int getSequenceNumber();	
	//
	public void killSelf();
	public void reset();
	//
	public GrapeWidget clone();
	public void afterClone();
	
	public void setHtml(String html);
	public String getHtml();
}
