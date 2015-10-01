package org.longbow.jgrapetree.test.cases;

import junit.framework.TestCase;

import org.jgrapetree.model.Widget;
import org.jgrapetree.model.form.GrapeForm;
import org.jgrapetree.model.form.GrapeWidget;
import org.jgrapetree.model.form.GrapeWidgetManager;

public class WidgetDnDCase extends TestCase  {
	TreeGenerator treeGenerator = new TreeGenerator();
	//drag, drop, copy, paste, copy from one tree to another...
	public void test1(){
		Widget n0 = treeGenerator.generateTree();
		Widget n3 = n0.getChild(1);
		Widget n2 = n0.getChild(2);
		Widget n1 = n0.getChild(0);
		n3.removeChildren();
		n2.moveTo(n3);		
		String s = loop(n0);
		assertEquals("n0n1n11nanbn12ncndn3n2n21nenfn22ngnh", s); 
		//		
		n0 = treeGenerator.generateTree();
		n3 = n0.getChild(1);
		n2 = n0.getChild(2);
		n3.removeChildren();
		//n2.moveBefore(n0, n3);
		n2.moveBefore(n3);
		s = loop(n0);
		assertEquals("n0n1n11nanbn12ncndn2n21nenfn22ngnhn3", s); 
		//
		n0 = treeGenerator.generateTree();
		n3 = n0.getChild(1);
		n2 = n0.getChild(2);
		n1 = n0.getChild(0);
		n3.removeChildren();
		//n2.moveAfter(n0, n1);
		n2.moveAfter(n1);
		s = loop(n0);
		assertEquals("n0n1n11nanbn12ncndn2n21nenfn22ngnhn3", s);
		//
		n0 = treeGenerator.generateTree();
		n3 = n0.getChild(1);
		n2 = n0.getChild(2);
		n1 = n0.getChild(0);
		Widget n4 = new GrapeWidget();
		n4.setAttr("name", "n4");
		//n4.moveAfter(n0, n1);
		n4.moveAfter(n1);
		s = loop(n0);
		assertEquals("n0n1n11nanbn12ncndn4n3n31n2n21nenfn22ngnh", s);
		
		//last child drop to same parent
		n0 = treeGenerator.generateTree();
		n3 = n0.getChild(1);
		n2 = n0.getChild(2);
		n1 = n0.getChild(0);
		
		n2.moveTo(n0);
		assertSame(3, n0.getChildrenSize());
		assertSame(2, n2.getSequenceNumber());
		n2.moveTo(20, n3);
		assertSame(2, n3.getChildrenSize());
		//check incest
		n0 = treeGenerator.generateTree();
		n3 = n0.getChild(1);
		n2 = n0.getChild(2);
		n1 = n0.getChild(0);
		Widget n21 = n2.getChild(0);
		n2.moveTo(n21);
		s = loop(n0);
		assertEquals("n0n1n11nanbn12ncndn3n31n2n21nenfn22ngnh", s);
	}
	public void test2(){
		Widget n0 = treeGenerator.generateTree();
		Widget n3 = n0.getChild(1);
		Widget n2 = n0.getChild(2);
		Widget n1 = n0.getChild(0);
		for(int i = 0; i < 10; i++){
			n3.moveUp();
		}
		for(int i = 0; i < 10; i++){
			n1.moveDown();
		}
		String s = loop(n0);
		assertEquals("n0n3n31n2n21nenfn22ngnhn1n11nanbn12ncnd", s);
	}
	public void test3(){
		Widget n0 = treeGenerator.generateTree();
		//
		Widget n3 = n0.getChild(1);
		Widget n2 = n0.getChild(2);
		Widget n1 = n0.getChild(0);		
		//
		n1.moveAfter(n2);
		//
		assertEquals("n3", n0.getChild(0).attr("name"));
		assertEquals("n2", n0.getChild(1).attr("name"));
		assertEquals("n1", n0.getChild(2).attr("name"));		
	}
	
	
	private String loop(Widget node){
		String s = node.getAttrAsStr("name");
		for(Widget n: node.getChildren()){
			s = s + loop(n);
		}
		return s;
	}
	
	
}
