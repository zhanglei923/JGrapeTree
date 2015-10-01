package org.longbow.jgrapetree.test.cases.io;

import java.util.Date;

import junit.framework.TestCase;

import org.jgrapetree.io.xml.XmlFileOperator;
import org.jgrapetree.io.xml.XmlSerializer;
import org.jgrapetree.model.Widget;
import org.jgrapetree.model.form.GrapeWidget;
import org.longbow.io.FileUtil;

public class XmlIOCase extends TestCase  {
	XmlFileOperator fo = new XmlFileOperator();
	XmlSerializer se = new XmlSerializer();
	//
	String xmlPath1 = "e:\\node1.xml";
	String xmlPath2 = "e:\\node2.xml";
	String xmlPath3 = "e:\\node3.xml";
	//
	public void test1(){
		
		Widget na = createTree();
		
		String xml = se.getString(na);
		//System.out.println(xml);
		
		fo.exp(xmlPath1, na);
		
		Widget nb = fo.imp(xmlPath1);
		fo.exp(xmlPath2, nb);
		fo.exp(xmlPath3, na.clone());
		
		Widget nc = fo.imp(xmlPath2);		
		compare1(na, nc);		
		assertTrue(compareResult1);
		
		Widget N000 = fo.imp(xmlPath3);		
		compare1(nc, N000);
		assertTrue(compareResult1);
		
		
		FileUtil.remove(xmlPath1);
		FileUtil.remove(xmlPath2);
		FileUtil.remove(xmlPath3);

	}
	public void test_performance(){
		Widget na = createTree();
		String xml = se.getString(na);
		fo.exp(xmlPath1, na);
		
		Date d1 = new Date();
		long longtime1 = d1.getTime();
		
		int TOTAL = 10;
		for(int i = 0; i< TOTAL;i++){
			Widget nb = fo.imp(xmlPath1);
			fo.exp(xmlPath1, nb.clone());			
		}
		
		Date d2 = new Date();
		long longtime2 = d2.getTime();
		
		
		System.out.println("PERFORMANCE:" + ((longtime2 - longtime1) / TOTAL) + " /Form");
		
	}
	public void compare1(Widget n0, Widget N0){
		compareResult1 = true;
		loop(n0, N0);
	}
	boolean compareResult1 = true;
	private void loop(Widget na, Widget nb){
		String sa = na.getAttrAsStr("name");
		String sb = nb.getAttrAsStr("name");
		
		try{
			if(na.hasAttr("name") && nb.hasAttr("name"))
			compareResult1 = compareResult1 && sa.equals(sb);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(sa+":"+sb);
			
		}
		int i = 0;
		for(Widget naa: na.getChildren()){
			Widget nbb = nb.getChild(i);
			loop(naa, nbb);
			i++;
		}
	}	
	
	private String loop(Widget node){
		String s = node.getAttrAsStr("name");
		for(Widget n: node.getChildren()){
			s = s + loop(n);
		}
		return s;
	}
	private Widget createTree(){
		/**
		 *               0
		 *            /  |   \
		 *           1   3     2
		 *         /  \  |    /  \
		 *       11   12 31  21   22
		 *     /  \  / \    /  \  /  \
	  	 *    a   b c   d  e   f g    h
		 */
		GrapeWidget n0 = new GrapeWidget();n0.setAttr("name", "n0");updateNode(n0);
        GrapeWidget n1 = new GrapeWidget();n1.setAttr("name", "n1");updateNode(n1);
        GrapeWidget n2 = new GrapeWidget();n2.setAttr("name", "n2");updateNode(n2);
        GrapeWidget n3 = new GrapeWidget();n3.setAttr("name", "n3");updateNode(n3);
        GrapeWidget n11 = new GrapeWidget();n11.setAttr("name", "n11");updateNode(n11);
        GrapeWidget n12 = new GrapeWidget();n12.setAttr("name", "n12");updateNode(n12);
        GrapeWidget n21 = new GrapeWidget();n21.setAttr("name", "n21");updateNode(n21);
        GrapeWidget n22 = new GrapeWidget();n22.setAttr("name", "n22");updateNode(n22);
        GrapeWidget n31 = new GrapeWidget();n31.setAttr("name", "n31");updateNode(n31);
        GrapeWidget na = new GrapeWidget();na.setAttr("name", "na");updateNode(na);
        GrapeWidget nb = new GrapeWidget();nb.setAttr("name", "nb");updateNode(nb);
        GrapeWidget nc = new GrapeWidget();nc.setAttr("name", "nc");updateNode(nc);
        GrapeWidget nd = new GrapeWidget();nd.setAttr("name", "nd");updateNode(nd);
        GrapeWidget ne = new GrapeWidget();ne.setAttr("name", "ne");updateNode(ne);
        GrapeWidget nf = new GrapeWidget();nf.setAttr("name", "nf");updateNode(nf);
        GrapeWidget ng = new GrapeWidget();ng.setAttr("name", "ng");updateNode(ng);
        GrapeWidget nh = new GrapeWidget();nh.setAttr("name", "nh");updateNode(nh);
        
        n0.addChild(n1);
        n0.addChild(n3);
        n0.addChild(n2);        
        //
        n1.addChild(n11);
        n1.addChild(n12);
        n3.addChild(n31);
        n2.addChild(n21);
        n2.addChild(n22);        
        //
        n11.addChild(na);
        n11.addChild(nb);
        n12.addChild(nc);
        n12.addChild(nd);
        n21.addChild(ne);
        n21.addChild(nf);
        n22.addChild(ng);
        n22.addChild(nh);
        
        return n0;
	}
	private GrapeWidget updateNode(GrapeWidget node){
		node.setAttr("attr_1", "aaaa\nbbbb\ncccc");
		node.setAttr("attr_2", 1234);
		node.setAttr("attr_3", 1234.1234);
		node.setAttr("attr_3", true);
		for(int i = 0; i < 500; i++){
			node.setAttr("attr__"+i, i);
		}
		for(int i = 0; i < 500; i++){
			GrapeWidget n = new GrapeWidget();
			n.setAttr("name", i+"\n"+i*2);
			node.addChild(n);
		}
		return node;
	}
	
}
