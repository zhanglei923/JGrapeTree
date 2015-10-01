package org.longbow.jgrapetree.test;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.longbow.jgrapetree.test.cases.io.MultiThreadFileBuildCase;

public class TestMultiThreadFileBuild {
	public static Test suite() {
        TestSuite suite = new TestSuite("MultiThreadHtmlBuild test");
        //suite.addTestSuite(MultiThreadFileBuildCase.class);
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
