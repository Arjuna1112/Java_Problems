package com.nestedclass.impl;

public class LocalClass {
	
	public void print(){
		class Local{
			public void print(){
				System.out.println("Hi......");
			}
		}
		Local local = new Local();
		local.print();
	}

}
