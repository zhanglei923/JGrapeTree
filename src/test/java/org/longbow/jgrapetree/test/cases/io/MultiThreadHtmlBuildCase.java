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
import java.util.List;
import java.util.Map;

import org.jgrapetree.build.html.HtmlBuilder;
import org.jgrapetree.build.html.HtmlBuilderImpl;
import org.jgrapetree.build.support.FormCarrier;
import org.jgrapetree.model.Form;
import org.jgrapetree.model.form.GrapeForm;
import org.jgrapetree.model.form.GrapeWidget;
import org.jgrapetree.model.form.GrapeWidgetManager;
import org.longbow.jgrapetree.test.cases.TreeGenerator;

import junit.framework.TestCase;

public class MultiThreadHtmlBuildCase extends TestCase{
	TreeGenerator treeGenerator = new TreeGenerator();
	
	int FORM_NUM = 10000;
	
	public void test1(){
		int count = FORM_NUM;
		List<Form> formList = Collections.synchronizedList(new ArrayList<Form>());
		for(int i = 0; i< count; i++){
			GrapeForm doc = treeGenerator.generateForm2();
			formList.add(doc);
		}		
		HtmlBuilder builder = new HtmlBuilder();
		
		Date d1 = new Date();
		long longtime1 = d1.getTime();
		/**********************/
		
		List<FormCarrier> result = builder.getStrings(formList, "EN");
		count = result.size();
		/**********************/
		Date d2 = new Date();
		long longtime2 = d2.getTime();
		long time = (longtime2 - longtime1);
		System.out.println(" MT DONE.");
		System.out.println(" CPU NUM:" + Runtime.getRuntime().availableProcessors());
		System.out.println(" TOTAL:" + time + "ms, "+count+"Forms");
		System.out.println(" PERFORMANCE(MT):" + (time / count) + "ms / Form");
		
		System.out.println(" VERIFYING...");
		boolean succ = verify(formList, result);
		System.out.println(" SUCC: " + succ);
		
		
		System.out.println("-----------------------------------");
		
		
	}
	private boolean verify(List<Form> formList, List<FormCarrier> result){
		Map<String, String> mapA = new HashMap<String, String>();
		Map<String, String> mapB = new HashMap<String, String>();
		String uid;
		for(Form form: formList){
			uid = form.getUid();
			mapA.put(uid, uid);
		}
		int size = -1;
		size = result.size();
		for(int i = 0; i < size; i++){
			FormCarrier carrier = (FormCarrier)result.get(i);
			uid = carrier.getFormUid();
			mapB.put(uid, uid);
		}
		assertEquals(""+mapA.keySet().size(), ""+mapB.keySet().size());
		
		boolean succ = true;
		//
		size = result.size();
		int error = 0;
		for(int i = 0; i < size; i++){
			Object obj = result.get(i);
			if(obj != null){
				FormCarrier carrier = (FormCarrier)obj;
				succ = succ && mapA.containsKey(carrier.getFormUid());
			}else{
				error++;
			}
		}
		System.out.println(" (error " + error +")");
		

		System.out.println(" (error " + error +")");
		return succ;
	}

}
