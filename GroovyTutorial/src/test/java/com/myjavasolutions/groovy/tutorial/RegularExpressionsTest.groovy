package com.myjavasolutions.groovy.tutorial;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.util.regex.Matcher;

import org.junit.Before;

class RegularExpressionsTest extends GroovyTestCase {

	@Before
	public void setUp() {
	}
	
	void test_simple_regex_string() {
		
		def someText = "Today is a beautiful Monday"
		// the char / tells groovy it is a regex expression
		//== ~ operator matches patterns
		assertTrue(someText ==~ /Today is a beautiful Monday/)
		
	}
	
	void test_optional_char() {
		
		def someText = "Today is a beautiful Monday"
		//? tells groovy that s is optional 
		assertTrue(someText ==~ /Today is a beautiful Mondays?/)
		assertFalse(someText ==~ /Today is a beautiful Mondas?/)
	}
	
	void test_either_or() {
		
		def someText = "Today is a nice day"
		
		//'|' character tells that either the thing to the left or the thing to the right is acceptable
		assertTrue(someText ==~ /Today is a (nice|bad) day/)
		assertTrue(someText ==~ /Today is a (bad|nice) day/)
		assertFalse(someText ==~ /Today is a bad day/)
		
		//optional ? char and either/or together
		assertTrue("Today is a nice day" ==~ /Today is an? (bad|nice) day/)
	}
	
	void test_group_of_characters() {
		
		def validUserId = "johndoe"
		
		//specifying a group of characters
		//Matched only the named characters in the brackets
		assertTrue(validUserId ==~ /john[adoe][adoe][adoe]/)
		
		//one of any upper or lower-case letter
		assertTrue(validUserId ==~ /john[a-zA-z][a-zA-z][a-zA-z]/)
		
		//all the characters are optional after john
		assertTrue("john" ==~ /john[a-zA-z]?[a-zA-z]?[a-zA-z]?/)
	}
	
	void test_occurences() { 
		
		//match an one or more occurrences of .
		assertTrue("some...Id@yahoo...com" ==~ /some.+Id@yahoo.+com/)
		
		//match zero or more occurrences of .
		assertTrue("some...Id@yahoo.com" ==~ /some.*Id@yahoo.com/)
		assertTrue("someId@yahoo.com" ==~ /some.*Id@yahoo.com/)
		
		//match zero or 1 occurrence of .
		assertTrue("some.Id@yahoo.com" ==~ /some.?Id@yahoo.com/)
		assertTrue("someId@yahoo.com" ==~ /some.?Id@yahoo.com/)
	}
	
	void test_string_cannot_end_with_digit() {
		
		//user id cannot end with digit
		assertFalse("johndoe1" ==~ /johndoe[^0-9]/)
	}
	
	void test_match_beginning_or_ending_of_a_string() {
		
		//match an .com is end of the string
		assertTrue("someId@yahoo.com" ==~ /someId@yahoo(.com)$/)
		
		//match an s at the beginning of a string
		assertTrue("someId@yahoo.com" ==~ /^someId@yahoo.com/)
	}
	
	void test_special_characters_usage() {
		
		//must use \ in front of all the special characters such as ?
		assertTrue("is this valid?" ==~ /is this valid\?/)
	}
	
	void test_accessing_the_last_char_in_the_matcher() {
		
		Matcher matcher = ("is this valid" =~ /is this valid/)
		int lastCharLocation = matcher[0].size() -1
		assertTrue("d" ==~ matcher[0][lastCharLocation])
	}
	
}
