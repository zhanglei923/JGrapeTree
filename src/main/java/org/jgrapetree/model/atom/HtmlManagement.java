package org.jgrapetree.model.atom;


public class HtmlManagement extends AttributeManagement{
	String ATTR_ID = "id";
	String ATTR_TYPE = "type";
	String html;
	StringBuffer sbhtml;
	public StringBuffer gethtmlAsSb() {
		return sbhtml;
	}
	public void setHtml(StringBuffer sbhtml) {
		this.sbhtml = sbhtml;
	}
	public String getId(){
		return this.getAttrAsStr("id");
	}
	public void setType(String type){
		this.setAttr(ATTR_TYPE, type);
	}
	public String getType(){
		return this.getAttrAsStr(ATTR_TYPE);
	}
	public void setHtml(String html){
		this.html = html;
	}
	public String getHtml(){
		return this.html;
	}
}
