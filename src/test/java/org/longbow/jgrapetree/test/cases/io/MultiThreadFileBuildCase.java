/* 
 * Copyright (c) 2014 ZhangLei
 * 
 * Author: ZhangLei
 * Homepage: https://github.com/zhanglei923 
 * Email: zhang.lei.923@gmail.com 
 * 
 * Under the term of the MIT License
 * http://www.opensource.org/licenses/mit-license.php
*/
package org.longbow.jgrapetree.test.cases.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapetree.build.html.HtmlBuilder;
import org.jgrapetree.build.html.HtmlBuilderImpl;
import org.jgrapetree.build.support.FormCarrier;
import org.jgrapetree.build.support.LargeDataBuildingSupport;
import org.jgrapetree.model.Form;
import org.jgrapetree.model.form.GrapeForm;
import org.jgrapetree.model.form.GrapeWidget;
import org.jgrapetree.model.form.GrapeWidgetManager;
import org.longbow.jgrapetree.test.cases.TreeGenerator;

import junit.framework.TestCase;

public class MultiThreadFileBuildCase extends TestCase{
	TreeGenerator treeGenerator = new TreeGenerator();
	
	int FORM_NUM = 21200;
	
	public void test1(){
		int count = FORM_NUM;
		List<GrapeForm> formList = new LinkedList<GrapeForm>();
		for(int i = 0; i< count; i++){
			GrapeForm doc = treeGenerator.generateForm2();
			formList.add(doc);
		}
		Date d1 = new Date();
		long longtime1 = d1.getTime();
		
		/**********************/		
		LargeDataBuildingSupport outputter = new LargeDataBuildingSupport();
		outputter.output(formList);
		
		verify(formList);
		
		System.out.println("-----------------------------------");
	}
	private boolean verify(List<GrapeForm> formList){
		boolean succ = true;
		return succ;
	}

}
