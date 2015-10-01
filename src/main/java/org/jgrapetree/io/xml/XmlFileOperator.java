package org.jgrapetree.io.xml;

import org.jgrapetree.model.Widget;
import org.jgrapetree.model.form.GrapeWidget;
import org.longbow.io.FileUtil;

public class XmlFileOperator implements org.jgrapetree.io.FileOperator{
	XmlSerializer se = new XmlSerializer();
	public void exp(String fullfilepath, Widget node){
		String content = se.getString(node);
		FileUtil.save(fullfilepath, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+content);
	}
	public Widget imp(String fullfilepath){
		String xmlString = FileUtil.getFileAsString(fullfilepath);
		return se.getWidget(xmlString);
	}
}
