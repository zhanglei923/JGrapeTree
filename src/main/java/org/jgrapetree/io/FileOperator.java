package org.jgrapetree.io;

import org.jgrapetree.model.Widget;

public interface FileOperator {
	public void exp(String fullfilepath, Widget node);
	public Widget imp(String fullfilepath);	
}
