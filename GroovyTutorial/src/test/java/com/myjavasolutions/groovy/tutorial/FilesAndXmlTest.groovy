package com.myjavasolutions.groovy.tutorial;

import groovy.util.GroovyTestCase;

import org.junit.Before;
import org.junit.Test;

//This test class assumes you have a test file named some_file.txt in the C:\test_files\ directory
//You can change the file location and the file name by changing the constant fields
//add couple lines of data in the file
class FilesAndXmlTest extends GroovyTestCase{

	final def FILE_LOCATION = "C:\\test_files\\";
	final def FILE_NAME = "some_file.txt";
	File file;
	
	@Before
	public void setUp() {
		//create a new file object
		file = new File(FILE_LOCATION + FILE_NAME)
	}
	
	void test_reading_each_line_from_file() {
		
		def printLine = { println "line: " + it }
		file.eachLine( printLine )
	}
	
	void test_xml_formatting_and_parsing() {
		
		//use triple quotes for multi line strings
		def someXmlDocument = '''
			<customers>
				<customer> <firstname gender="m">John</firstname> <lastname>Doe</lastname> </customer>
				<customer> <firstname gender="m">Doe</firstname>  <lastname>John</lastname></customer>
			</customers>
		'''
		
		println "before formatting: " + someXmlDocument
		//let's remove the indentation and print out the string as one line
		 println "after formatting: " + someXmlDocument.split("\n").collect { it.trim() }.join(" ")
		 
		def customers = new XmlParser().parseText(someXmlDocument);
		
		def customer = customers.customer[0]
		assert "John" == customer.firstname.text()
		
		//same as above, but with one line
		assert "Doe" == customers.customer[0].lastname.text()
		
		assert 2 == customers.customer.size()
	}
}