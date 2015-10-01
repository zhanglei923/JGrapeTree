package org.longbow.jgrapetree.test.cases;

import junit.framework.TestCase;

import org.jgrapetree.model.form.GrapeWidget;

public class WidgetAttrCase extends TestCase {
	public void testChildren(){
        GrapeWidget n = new GrapeWidget();
        //asXXX
        n.setAttr("name", "leizhang");
        assertEquals("leizhang",n.getAttrAsStr("name"));
        n.setAttr("name", "zhanglei");
        assertEquals("zhanglei", n.getAttrAsStr("name"));
        assertSame(null, n.getAttrAsInt("name"));
        //string
        n.setAttr("attr_obj", new Object());
        n.setAttr("attr_int", 123);
        n.setAttr("attr_obj", new Object());
        n.setAttr("attr_float", 123.321);
        //
        assertSame(null, n.getAttrAsStr("attr_null"));
        assertEquals("123", n.getAttrAsStr("attr_int"));
        assertSame(123, n.getAttrAsInt("attr_int"));
        assertEquals(123.321, n.getAttrAsFloat("attr_float"), 0.002);
        assertSame(null, n.getAttrAsInt("attr_null"));
        assertSame(null, n.getAttrAsInt("attr_obj"));
        //has
        n.setAttr("age", 30);
        assertEquals("30", n.getAttrAsStr("age"));
        assertTrue(n.hasAttr("age"));
        assertTrue(n.hasAttr("age", 30));
        assertTrue(n.hasAttr("age", "30"));
        assertSame(30, n.getAttrAsInt("age"));
        n.setAttr("addr", "xxxxxxxx");
        assertTrue(n.hasAttr("addr"));
        assertTrue(n.hasAttr("addr", "xxxxxxxx"));
        assertFalse(n.hasAttr("addr1"));
        assertFalse(n.hasAttr("addr1", "yyyyyyyyy"));
        //del
        n.setAttr("desc", "blablabla");
        n.delAttr("desc");
        assertFalse(n.hasAttr("desc"));
        //rename
        n.setAttr("desc1", "blablabla");
        n.renameAttr("desc1", "desc2");
        assertFalse(n.hasAttr("desc1"));        
        assertTrue(n.hasAttr("desc2"));
        assertTrue(n.hasAttr("desc2", "blablabla"));
        //hasTrue, hasFalse
        assertFalse(n.hasAttr("true-attr"));
        n.setAttr("true-attr", "true");        
        assertTrue(n.hasTrue("true-attr"));
        n.setAttr("true-attr", "True");
        assertTrue(n.hasTrue("true-attr"));
        n.setAttr("true-attr", "TRUE");        
        assertTrue(n.hasTrue("true-attr"));
        n.setAttr("true-attr", null);        
        assertFalse(n.hasTrue("true-attr"));
        n.setAttr("true-attr", "something else");        
        assertFalse(n.hasTrue("true-attr"));
        
        assertFalse(n.hasAttr("false-attr"));
        n.setAttr("false-attr", "false");        
        assertTrue(n.hasFalse("false-attr"));
        n.setAttr("false-attr", "False");        
        assertTrue(n.hasFalse("false-attr"));
        n.setAttr("false-attr", "FALSE");        
        assertTrue(n.hasFalse("false-attr"));
        n.setAttr("false-attr", null);        
        assertFalse(n.hasFalse("false-attr"));
        n.setAttr("false-attr", "something else");        
        assertFalse(n.hasFalse("false-attr"));
    }
}
