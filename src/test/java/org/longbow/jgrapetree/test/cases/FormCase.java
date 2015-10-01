package org.longbow.jgrapetree.test.cases;

import java.util.List;

import junit.framework.TestCase;

import org.jgrapetree.io.xml.XmlSerializer;
import org.jgrapetree.model.Widget;
import org.jgrapetree.model.form.GrapeWidget;
import org.jgrapetree.model.form.GrapeWidgetManager;

public class FormCase extends TestCase {
	TreeGenerator treeGenerator = new TreeGenerator();
	public void testChildren(){
		GrapeWidgetManager doc = treeGenerator.generateForm();
		Widget root = doc.getRoot();
		assertNotNull(root);
		assertSame(3,root.getChildrenSize());
		List<Widget> wlist = doc.getAllWidgets();
		assertEquals(17, wlist.size());
		
		Widget n3 = root.getChild(1);
		doc.delWidget(n3.getUid());
		XmlSerializer se = new XmlSerializer();
		
		assertSame(2,root.getChildrenSize());
		assertEquals("n1", root.getFirstChild().getAttrAsStr("name"));
		assertEquals("n2", root.getLastChild().getAttrAsStr("name"));
		assertEquals("n2", root.getChild(1).getAttrAsStr("name"));
		
		//copy,paste
		doc = treeGenerator.generateForm();
		root = doc.getRoot();
		Widget n1 = root.getFirstChild();
		doc.copyWidget(n1.getUid(), root.getUid());
		assertEquals(4, root.getChildrenSize());
		assertEquals(n1.getAttrAsStr("name"), root.getLastChild().getAttrAsStr("name"));
		assertEquals(n1.getChildrenSize(), root.getLastChild().getChildrenSize());
    }
	
	//
}
