package com.nestedclass.impl;


/*The purpose of a nested class is to clearly group the nested class with its surrounding class, signaling that 
these two classes are to be used together.Or perhaps that the nested class is only to be used from inside its 
enclosing (owning) class.*/

/*Java developers often refer to nested classes as inner classes, but inner classes (non-static nested classes) are
only one out of several different types of nested classes in Java.*/

public class NestedClassTester {
	
	public static void main(String args[]) {
		NestedClassTester n = new NestedClassTester();
		n.staticNestedClassTester();
		n.NonStaticNested_Or_InnerClass_Tester();
	}
	
	/*In Java a static nested class is essentially a normal class that has just been nested inside another class.
	Being static, a static nested class can only access	instance variables of the enclosing class via a reference 
	to an instance of the enclosing class*/
	public void staticNestedClassTester(){
		StaticNestedClass.Nested nestedClass = new StaticNestedClass.Nested();
		nestedClass.print();
	}
	
	/*Non-static nested classes in Java are also called inner classes. Inner classes are associated with an instance 
	of the enclosing class. Thus, you must first create an instance of the enclosing class to create an instance of 
	an inner class. Here is an example inner class definition:*/
	
	//Notice how you put new after the reference to the outer class in order to create an instance of the inner class.
	
	/*Non-static nested classes (inner classes) have access to the fields of the enclosing class, even if they are declared
	private. Here is an example of that*/
	
	/*Notice how the printText() method of the Inner class references the private text field of the Outer class. This is 
	perfectly possible. Here is how you would call the printText() method:*/
	
	//Note : For Shadowing of inner class refer the NonStaticNested_Or_InnerClass file
	public void NonStaticNested_Or_InnerClass_Tester(){
		NonStaticNested_Or_InnerClass outerClass = new NonStaticNested_Or_InnerClass();
		NonStaticNested_Or_InnerClass.Inner innerClass = outerClass.new Inner();
		innerClass.print();
	}
	
	//Local classes can only be accessed from inside the method or scope block in which they are defined
	
	//Local classes can access members (fields and methods) of its enclosing class just like regular inner classes.
	
	/*Local classes can also access local variables inside the same method or scope block, provided these variables are 
	declared final.*/
	
	/*From Java 8 local classes can also access local variables and parameters of the method the local class is declared in. 
	The parameter will have to be declared final or be effectually final. Effectually final means that the variable is never
	changed after it is initialized. Method parameters are often effectually final.*/
	
	/*Local classes can also be declared inside static methods. In that case the local class only has access to the static 
	parts of the enclosing class. Local classes cannot contain all kinds of static declarations (constants are allowed - 
	variables declared static final), because local classes are non-static in nature - even if declared inside a static method.*/
	
	//The same shadowing rules apply for local classes as for inner classes
	
	//Note : As we can not access local class from other class please refer LocalClass file for implementation
	public void LocalClasstester(){
		
	}
	
	/*Anonymous classes in Java are nested classes without a class name. They are typically declared as either subclasses of an 
	existing class, or as implementations of some interface.*/
	
	/*Anonymous classes are defined when they are instantiated. Here is an example that declares an anonymous subclass of a 
	superclass called SuperClass*/
	
	/*Running this Java code would result in Anonymous class doIt() being printed to System.out. The anonymous class subclasses 
	(extends) SuperClass and overrides the doIt() method*/
	
	AnonymusClass anonymusClass = new AnonymusClass(){
		public void doIt() {
		    System.out.println("Anonymous class doIt()");
		}
	};
	
	//A Java anonymous class can also implement an interface instead of extending a class. Here an example:
	
	/*As you can see, an anonymous class implementing an interface is pretty similar to an anonymous class extending another
	class.*/

	/*An anonymous class can access members of the enclosing class. It can also access local variables which are declared final
	or effectively final (since Java 8).*/
	
	AnonymusMyInterface instance = new AnonymusMyInterface() {

	    public void doIt() {
	        System.out.println("Anonymous class doIt()");
	    }
	};
	
	/*You can declare fields and methods inside an anonymous class, but you cannot declare a constructor. You can declare a 
	static initializer for the anonymous class instead, though. Here is an example:*/
	
	//The same shadowing rules apply to anonymous classes as to inner classes.
	AnonymusMyInterface instance1 = new AnonymusMyInterface() {

	    private String text;

	    //static initializer
	    {  this.text = textToPrint;  }

	    public void doIt() {
	        System.out.println(this.text);
	    }
	};
	
	//For benefits of nested class please refer NestedClassBenefits file.
}
