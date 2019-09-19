package com.arvindsrivastava.poc;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestMain {

	public static void main(String[] args) {
	    Result result = JUnitCore.runClasses(AppTest.class);
	    
	    System.out.println(" Total number of tests run = " + result.getRunCount());
	    System.out.println(" Total number of failed tests = " + result.getFailureCount());
	    
	    for (Failure failure : result.getFailures()) {
	      System.out.println("Test failed = " + failure.toString());
	    }
	}

}
