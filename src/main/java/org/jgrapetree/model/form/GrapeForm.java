package org.jgrapetree.model.form;

import org.jgrapetree.model.Form;
import org.jgrapetree.model.Widget;
import org.jgrapetree.util.MathUtil;

public class GrapeForm extends GrapeWidgetManager implements Cloneable{
	protected String uid = null;
	
	public GrapeForm(Widget node){
		this.generateUid();
		this.addWidget(node);
	}
	
	public GrapeForm(){
		this.generateUid();
	}
	
	public String getUid() {
		return this.uid;
	}
	protected void generateUid(){
		if(this.uid == null){
			MathUtil mu = new MathUtil();
			this.uid =  "f" + mu.getHexStr();
		}		
	}
	
	String folderPath;
	String filePath;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	
	
	
	
}
