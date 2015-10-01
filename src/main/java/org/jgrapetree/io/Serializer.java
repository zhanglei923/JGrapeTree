package org.jgrapetree.io;

import org.jgrapetree.model.Form;
import org.jgrapetree.model.Widget;

public interface Serializer {
	public String getString(Form doc);
	public String getString(Widget node);
	public Form getForm(String str);
	public Widget getWidget(String str);
}
