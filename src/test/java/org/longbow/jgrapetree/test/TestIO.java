package org.longbow.jgrapetree.test;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.longbow.jgrapetree.test.cases.io.XmlIOCase;

public class TestIO {
	public static Test suite() {
        TestSuite suite = new TestSuite("WidgetTree basic test");
        suite.addTestSuite(XmlIOCase.class);
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
