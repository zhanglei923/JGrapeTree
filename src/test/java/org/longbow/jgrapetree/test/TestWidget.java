package org.longbow.jgrapetree.test;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.longbow.jgrapetree.test.cases.WidgetAttrCase;
import org.longbow.jgrapetree.test.cases.WidgetChildCase;
import org.longbow.jgrapetree.test.cases.WidgetCloneCase;

public class TestWidget {
	public static Test suite() {
        TestSuite suite = new TestSuite("TestNode");
        suite.addTestSuite(WidgetAttrCase.class);
        suite.addTestSuite(WidgetChildCase.class);
        suite.addTestSuite(WidgetCloneCase.class);
        return suite;
    } 

	public static void main(String[] args) {
		TestResult tr = TestRunner.run(suite());
		System.out.println("--------");
		System.out.println("Fail:" + tr.failureCount());
		System.out.println("Error:" + tr.errorCount());
		System.out.println("Success:" + tr.wasSuccessful());
	}
}
