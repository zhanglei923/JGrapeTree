package org.longbow.jgrapetree.test.cases;

import java.util.List;

import junit.framework.TestCase;

import org.jgrapetree.model.Widget;
import org.jgrapetree.model.form.GrapeWidget;

public class WidgetChildCase extends TestCase {
	TreeGenerator treeGenerator = new TreeGenerator();
	public void test1(){
		Widget n0 = treeGenerator.generateTree();
		Widget n1 = n0.getFirstChild();
		Widget n3 = n0.getChild(1);
		Widget n2 = n0.getLastChild();
        //children size		
        assertTrue(n0.hasChild());
        assertTrue(n0.hasChild(n1.getUid()));
        assertTrue(n1.hasParent());
        assertFalse(n0.hasParent());
        assertEquals(3, n0.getChildrenSize());
        assertNotSame(3, n1.getChildrenSize());
        //get
        assertEquals(n1, n0.getChild(0));
        assertEquals(n1, n0.getChild(n1.getUid()));
        assertEquals(n3, n0.getChild(1));
        assertEquals(n1, n0.getFirstChild());
        assertEquals(n2, n0.getLastChild());        
        //sequence
        assertSame(1, n0.getSequenceNumber(n3.getUid()));
        assertSame(2, n0.getSequenceNumber(n2));
        assertSame(-1, n0.getSequenceNumber(new GrapeWidget()));
        //del
        assertTrue(n0.hasChild(n3));
        n0.removeChild(n3);
        assertEquals(2, n0.getChildrenSize());
        assertFalse(n0.hasChild(n3));
        assertEquals(n2.getUid(), n0.getLastChild().getUid());
    }
	public void test2(){
		Widget n0 = treeGenerator.generateTree();
		Widget n3 = n0.getChild(1);
		Widget n2 = n0.getChild(2);
		//del
		n3.removeChildren();
		n2.moveTo(n3);
		
		String s = loop(n0);
		assertEquals("n0n1n11nanbn12ncndn3n2n21nenfn22ngnh", s);
	}
	public void test3(){
		GrapeWidget n0 = treeGenerator.generateTree();		
		assertEquals("n0", n0.getAttrAsStr("name"));
		String s = loop(n0);
		assertEquals("n0n1n11nanbn12ncndn3n31n2n21nenfn22ngnh", s);
	}
	public void test4(){
		Widget n0 = treeGenerator.generateTree();		
		Widget na = n0.getChild(0).getChild(0).getChild(0);
		List<Widget> parents = na.getParents();
		assertEquals(3, parents.size());
		assertEquals("n11", parents.get(0).getAttrAsStr("name"));
		assertEquals("n1", parents.get(1).getAttrAsStr("name"));
		assertEquals("n0", parents.get(2).getAttrAsStr("name"));
		
		String s = "";
		for(int i = (parents.size() - 1); i >= 0; i--){
			String name = parents.get(i).getAttrAsStr("name");
			s = s + name;
			//System.out.println(name);
		}
		assertEquals("n0n1n11", s);
	}
	//
	private String loop(Widget node){
		String s = node.getAttrAsStr("name");
		for(Widget n: node.getChildren()){
			s = s + loop(n);
		}
		return s;
	}
}
