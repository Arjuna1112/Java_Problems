package com.nestedclass.impl;

/*If a Java inner class declares fields or methods with the same names as field or methods in its enclosing class, 
the inner fields or methods are said to shadow over the outer fields or methods. Here is an example:*/

/*In the above example both the Outer and Inner class contains a field named text. When the Inner class refers to 
text it refers to its own field. When Outer refers to text it also refers to its own field.*/

/*Java makes it possible though, for the Inner class to refer to the text field of the Outer class. To do so it has
to prefix the text field reference with Outer.this. (the outer class name + .this. + field name) like this*/

//Now the Inner.print method will print both the Inner.text and Outer.text fields

public class NonStaticNested_Or_InnerClass {
	
	private String text = "Hello How Are You";
	
	public class Inner{
		private String text = "I am fine";
		
		public void print(){
			System.out.println(text);
			System.out.println(NonStaticNested_Or_InnerClass.this.text);
		}
	}

}
