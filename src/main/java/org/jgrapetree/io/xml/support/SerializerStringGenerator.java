package org.jgrapetree.io.xml.support;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jgrapetree.model.Widget;
import org.jgrapetree.model.form.GrapeWidget;

public class SerializerStringGenerator{	
	public String getString(Widget node){
		StringBuilder sb = new StringBuilder();
		toStringBuilder(node, sb);
		return sb.toString();
	}
	private void toStringBuilder(Widget node, StringBuilder sb){
		//StringBuilder sb2 = new StringBuilder();
		Map attrmap = node.getAttributes();
		Iterator it = attrmap.keySet().iterator();
		String attrName = "";
		String attrValue = "";
		//node
		sb.append("<n");
		List<String> list = new ArrayList();
		//attribute
		while(it.hasNext()){
			attrName = it.next().toString();
			attrValue = node.getAttrAsStr(attrName);
			
			if(attrValue.indexOf("\n")<0){
				sb.append(" ");
				sb.append(attrName);
				sb.append("=\"");
				sb.append(attrValue);
				sb.append("\"");
			}else{
				list.add(attrName);
			}
		}
		sb.append(">");
		//line break
		for(String attrNameBL: list){//attribute content with break lines
			sb.append("<attr");
			sb.append(" name=\"");
			sb.append(attrNameBL);
			sb.append("\"><![CDATA[");
			sb.append(node.getAttrAsStr(attrNameBL));			
			sb.append("]]></attr>");
		}
		
		//children
		if(node.hasChild()){
			for(Widget n: node.getChildren()){
				this.toStringBuilder(n, sb);
			}
			
		}
		sb.append("</n>");
	}
}
