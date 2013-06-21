package com.myjavasolutions.groovy.tutorial;

import static org.junit.Assert.*;


import static org.junit.Assert.*;
import groovy.util.GroovyTestCase;

import org.junit.Before;

class SomeInterfaceTest extends GroovyTestCase {
	
	@Before
	public void setUp() {
	}
	
	void test_implementing_an_interface_with_closure() {
		
		//using a closure to implement an interface
		def myInterface = {Object[] args -> println "The following parameters are passed to the method: $args"} as SomeInterface
		
		myInterface.doSomeThing()
		myInterface.doSomeThing(1,5)
		myInterface.doSomeThing("hi")
	}
}
