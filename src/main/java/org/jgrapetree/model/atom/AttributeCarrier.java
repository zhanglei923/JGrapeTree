/* 
 * Copyright (c) 2014 ZhangLei
 * 
 * Author: ZhangLei
 * Homepage: https://github.com/zhanglei923 
 * Email: zhang.lei.923@gmail.com 
 * 
 * Under the term of the Apache 2.0 License
 * http://www.opensource.org/licenses/mit-license.php
*/
package org.jgrapetree.model.atom;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AttributeCarrier {
	private Map<String, Object> attributes = Collections.synchronizedMap(new HashMap());//HashMap<String, Object> attributes = new HashMap();
	
	//
	public void setAttr(String attrName, Object attrValue){
		attributes.put(attrName, attrValue);		
	}
	public Object getAttr(String attrName){
		return attributes.get(attrName);		
	}
	public String getAttrAsStr(String attrName) {
		if (!hasAttr(attrName))return null;
		Object obj = getAttr(attrName);
		return String.valueOf(obj);
	}
	public Integer getAttrAsInt(String attrName) {
		if (!hasAttr(attrName))return null;
		String s = getAttrAsStr(attrName);
		Integer result = null;
		try {
			result = Integer.parseInt(s);
		} catch (Exception e) {
			result = null;
		}
		return result;		
	}
	public Float getAttrAsFloat(String attrName) {
		if (!hasAttr(attrName))return null;
		String s = getAttrAsStr(attrName);
		Float result = null;
		try {
			result = Float.parseFloat(s);
		} catch (Exception e) {
			result = null;
		}
		return result;		
	}
	public boolean hasAttr(String attrName) {
		return this.attributes.get(attrName) == null ? false : true;
	}
	public boolean hasAttr(String attrName, String attrValue) {
		if (!hasAttr(attrName)) {
			return false;
		} else {
			String s = getAttrAsStr(attrName);
			return attrValue.equals(s);
		}
	}
	public boolean hasTrue(String attrName) {
		if(this.hasAttr(attrName)){
			String str = this.getAttrAsStr(attrName).toLowerCase();
			return "true".equals(str);
		}
		return false;
	}
	public boolean hasFalse(String attrName) {
		if(this.hasAttr(attrName)){
			String str = this.getAttrAsStr(attrName).toLowerCase();
			return "false".equals(str);
		}
		return false;
	}
	/**
	* Return true if containing this attribute and it's value equals to the given one.
	* @param attrName String
	* @param attrValue int
	* @return boolean
	*/ 
	public boolean hasAttr(String attrName, int attrValue) {
		if (!hasAttr(attrName)) {
			return false;
		} else {
			int val = getAttrAsInt(attrName);
			return val == attrValue;
		}
	}
	public void delAttr(String attrName) {
		if (hasAttr(attrName)) {
			this.attributes.remove(attrName);
		}
	}
	public void renameAttr(String oldName, String newName) {
		if (hasAttr(oldName)) {
			Object obj = this.getAttr(oldName);
			setAttr(newName, obj);
			this.delAttr(oldName);
		}
	}
	//
	public Map<String, Object> getAttributes(){
		return this.attributes;
	}
	//
	public void resetAttr(){
		this.attributes = Collections.synchronizedMap(new HashMap());		
	}
	protected void killAttr(){
		this.attributes = null;
	}
}