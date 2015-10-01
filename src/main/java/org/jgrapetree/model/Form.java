package org.jgrapetree.model;

import java.util.List;

public interface Form {
	public String getUid();
	public void setUid(String id);
	
	public Widget getRoot();
	public void setRoot(Widget rootNode);
	public boolean addWidget(Widget node);
	public Widget getWidget(String uid);
	public List<Widget> getAllWidgets();
	public boolean hasWidget(Widget node);
	public boolean hasWidget(String uid);
	public void delWidget(String uid);
	public void delWidget(Widget node);
	public Form clone();
	public boolean copyWidget(String copyUid, String pasteUid);
}
