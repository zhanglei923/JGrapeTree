package org.longbow.jgrapetree.test.cases;

import java.util.List;

import junit.framework.TestCase;

import org.jgrapetree.model.Widget;
import org.jgrapetree.model.form.GrapeWidget;

public class WidgetCloneCase extends TestCase {
	public void testClone(){
		Widget na = createTree();
		Widget na1 = na.getChild(0);
		Widget na2 = na.getChild(1);
		Widget na3 = na.getChild(2);  
		Widget na21 = na2.getChild(0);
		Widget na22 = na2.getChild(1);
		Widget na31 = na3.getChild(0);
		Widget na32 = na3.getChild(1);
		Widget na211 = na21.getChild(0);
		Widget na212 = na21.getChild(1);
        String uid1 = na.getUid();
        //
        Widget nb = new GrapeWidget();
		nb = na.clone();
		
		Widget nb1 = nb.getChild(0);
		Widget nb2 = nb.getChild(1);
		Widget nb3 = nb.getChild(2);  
		Widget nb21 = nb2.getChild(0);
		Widget nb22 = nb2.getChild(1);
		Widget nb31 = nb3.getChild(0);
		Widget nb32 = nb3.getChild(1);
		Widget nb211 = nb21.getChild(0);
		Widget nb212 = nb21.getChild(1);
        //
        assertFalse(na == nb);
        assertFalse(na1 == nb1);
        assertSame(na.getChildrenSize(), nb.getChildrenSize());    
        assertEquals(na.getFirstChild().getAttrAsStr("name"), nb.getFirstChild().getAttrAsStr("name"));
        assertNotSame(na.getUid(), nb.getUid());            
        assertNotSame(na.getFirstChild().getUid(), nb.getFirstChild().getUid());
        
        assertSame(na2.getChildrenSize(), nb2.getChildrenSize());
        assertSame(na21.getAttrAsStr("name"), nb21.getAttrAsStr("name"));
        na21.setAttr("name", "newname");
        assertNotSame(na21.getAttrAsStr("name"), nb21.getAttrAsStr("name"));
        assertFalse(na21 == nb21);
        //
        assertSame(na211.getAttrAsStr("name"), nb211.getAttrAsStr("name"));
        assertFalse(na211 == nb211);
    }
	//test parentUid, and relation of new clone tree
	public void testClone2(){
		TreeGenerator treeGenerator = new TreeGenerator();
		Widget n0 = treeGenerator.generateTree();
		Widget n2 = n0.getChild(2);
		Widget new_n2 = n2.clone();
		n0.addChild(new_n2);
		//
		Widget ne = n2.getChild(0).getChild(0);
		Widget new_ne = new_n2.getChild(0).getChild(0);
		//
		assertNotSame(ne.getUid(), new_ne.getUid());
		assertNotSame(ne.getParent().getUid(), new_ne.getParent().getUid());
		//
		String s1 = "";
		String s2 = "";
		List<Widget> ps1 = ne.getParents();
		List<Widget> ps2 = new_ne.getParents();
		
		for(int i = (ps1.size() - 1); i >= 0; i--){
			Widget p1 = ps1.get(i);
			Widget p2 = ps2.get(i);
			String uid1 = p1.getUid();
			String uid2 = p2.getUid();
			if(!p1.hasAttr("name", "n0"))
				assertNotSame(uid1, uid2);
			else
				assertSame(uid1, uid2);//n0 is the same
		}
		
	}
	//
	private GrapeWidget createTree(){
        GrapeWidget n1 = new GrapeWidget();
        //
        GrapeWidget n11 = new GrapeWidget();n11.setAttr("name", "n11");
        GrapeWidget n12 = new GrapeWidget();n12.setAttr("name", "n12");
        GrapeWidget n13 = new GrapeWidget();n13.setAttr("name", "n13");
        //
        GrapeWidget n121 = new GrapeWidget();n121.setAttr("name", "n121");
        GrapeWidget n122 = new GrapeWidget();n122.setAttr("name", "n122");
        GrapeWidget n131 = new GrapeWidget();n131.setAttr("name", "n131");
        GrapeWidget n132 = new GrapeWidget();n132.setAttr("name", "n132");
        //
        GrapeWidget n1211 = new GrapeWidget();n1211.setAttr("name", "n1211");       
        GrapeWidget n1212 = new GrapeWidget();n1212.setAttr("name", "n1212");    
        //
        n121.addChild(n1211);
        n121.addChild(n1212);
        n12.addChild(n121);
        n12.addChild(n122);
        n13.addChild(n131);
        n13.addChild(n132);
        n1.addChild(n11);
        n1.addChild(n12);
        n1.addChild(n13);
		return n1;
	}
}
