package org.jgrapetree.io.xml.support;

import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jgrapetree.model.form.GrapeWidget;

public class SerializerNodeGenerator{
	public GrapeWidget getNode(String xmlString){
		if(xmlString == null) return null;
		Document dom = null;
		try{
			dom = DocumentHelper.parseText(xmlString);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(dom == null) return null;
		Element rootElem = dom.getRootElement();
		GrapeWidget node = createNode(rootElem);
		return node;
	}
	private GrapeWidget createNode(Element elem){
		GrapeWidget node = new GrapeWidget();
		//attributes
		for(Iterator<Attribute> it = elem.attributeIterator(); it.hasNext();){
			Attribute attr = (Attribute)it.next();
			node.setAttr(attr.getName(), attr.getValue());
		}
		for(Iterator<Element> it = elem.elementIterator("attr"); it.hasNext();){
			Element el = (Element)it.next();
			node.setAttr(el.attributeValue("name"), el.getText());
		}
		//children
		for(Iterator<Element> it = elem.elementIterator("n"); it.hasNext();){
			Element el = (Element)it.next();
			GrapeWidget n = createNode(el);
			node.addChild(n);
		}		
		return node;
	}
}
