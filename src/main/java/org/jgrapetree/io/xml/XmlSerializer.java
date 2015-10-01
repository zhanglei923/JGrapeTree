package org.jgrapetree.io.xml;

import org.jgrapetree.io.xml.support.SerializerNodeGenerator;
import org.jgrapetree.io.xml.support.SerializerStringGenerator;
import org.jgrapetree.model.Form;
import org.jgrapetree.model.Widget;
import org.jgrapetree.model.form.GrapeForm;
import org.jgrapetree.model.form.GrapeWidget;
import org.jgrapetree.model.form.GrapeWidgetManager;

public class XmlSerializer implements org.jgrapetree.io.Serializer{
	SerializerNodeGenerator nodeGen = new SerializerNodeGenerator();
	SerializerStringGenerator strGen = new SerializerStringGenerator();

	public String getString(Form doc) {
		String s = strGen.getString(doc.getRoot());
		return s;
	}
	public String getString(Widget node) {
		String s = strGen.getString(node);
		return s;
	}
	public Form getForm(String str) {
		GrapeWidget node = nodeGen.getNode(str);
		Form document = new GrapeForm();
		document.addWidget(node);
		return document;
	}
	public Widget getWidget(String str) {
		GrapeWidget node = nodeGen.getNode(str);
		return node;
	}
}
