package com.myjavasolutions.groovy.tutorial

//activate type checking since we are not interested of adding runtime behavior to
//this class. With the following line the compiler will report errors at compile time 
//instead of runtime
@groovy.transform.TypeChecked
class GroovyDemo {

	//by default the following field is private and
	//groovy provides getters and setters by default
	String firstName;
	
	int companyId;
	
	/*
	 * the following method shows how you can define optional parameters
	 * assign them to zero to make them optional
	 */
	static BigDecimal getPrice(String prodId, String location, int promoCode=0) {
		
		BigDecimal price = 26.0;
		
		if(promoCode > 0) {
			return 10.0;
		}
		return price;
	}
	
	
	/*
	 * the following method will be called when the caller
	 * calls a missing method
	 */
	def methodMissing (String name, args){
		
			println "The method $name is missing"
			//output the method params
			args.each {output -> println output }
	}

	/*
	 * the following method will be called when the caller
	 * calls a missing getter method
	 */
	Object getProperty (String property){
		return "this getter property does not exists"
	  }
	  
	/*
	 * the following method will be called when the caller
	 * calls a missing setter method
	 */
	void setProperty (String property, Object o){
		println "this setter property does not exists"
		println property
	}
	
	public boolean returnValueOptionalWithBoolean(String name=0) {
		println "this method shows that the return statement is optional and the parameter with default value: " + name
	}
	
	public String returnValueOptionalString() {
		println "this method shows that the return statement is optional."
	}
	
	def someLocalMethod() {
		return { "hello"}
	}
	
	/*
	 * Groovy does not require the return keyword. It will simply return the last expression.
	 */
	private String whatIsMyReturnType(String input) {

		def someString = "The return type"
		someString = someString + " " +  input
		input
	}
	
	/*
	 * Groovy does not require type for the method parameter
	 */
	private String echo(input) {
		input
	}
}
