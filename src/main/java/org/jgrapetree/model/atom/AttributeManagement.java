package org.jgrapetree.model.atom;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/*
 * Grape focus on attribute management.
 * 
 * 
 */
public class AttributeManagement extends EventManagement{
	
	AttributeCarrier attrCarrier = new AttributeCarrier();
	
	public AttributeManagement(){
	}
	
	//
	public void setAttr(String attrName, Object attrValue){
		attrCarrier.setAttr(attrName, attrValue);
	}
	public Object getAttr(String attrName){
		return attrCarrier.getAttr(attrName);
	}
	public String getAttrAsStr(String attrName) {
		return attrCarrier.getAttrAsStr(attrName);
	}
	public Integer getAttrAsInt(String attrName) {
		return attrCarrier.getAttrAsInt(attrName);
	}
	public Float getAttrAsFloat(String attrName) {
		return attrCarrier.getAttrAsFloat(attrName);	
	}
	public boolean hasAttr(String attrName) {
		return attrCarrier.hasAttr(attrName);
	}
	public boolean hasAttr(String attrName, String attrValue) {
		return attrCarrier.hasAttr(attrName, attrValue);
	}
	public boolean hasTrue(String attrName) {
		return attrCarrier.hasTrue(attrName);
	}
	public boolean hasFalse(String attrName) {
		return attrCarrier.hasFalse(attrName);
	}
	public boolean hasAttr(String attrName, int attrValue) {
		return attrCarrier.hasAttr(attrName, attrValue);
	}
	public void delAttr(String attrName) {
		attrCarrier.delAttr(attrName);
	}
	public void renameAttr(String oldName, String newName) {
		attrCarrier.renameAttr(oldName, newName);
	}
	//
	public Map<String, Object> getAttributes(){
		return attrCarrier.getAttributes();
	}
	//
	public void resetAttr(){
		attrCarrier.resetAttr();
	}
	protected void killAttr(){
		attrCarrier.killAttr();
	}
	
	//For tpl only!
	public String attr(String attrName){
		return getAttrAsStr(attrName);
	}
	public int intAttr(String attrName){
		return getAttrAsInt(attrName);
	}
	public float floatAttr(String attrName){
		return getAttrAsFloat(attrName);
	}
}
