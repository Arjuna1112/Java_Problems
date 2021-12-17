package com.collections.implementation;


import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class TestClass
{
	public static void main(String args[]){
		Singleton s = Singleton.getInstance();
		s.setAge(11);
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2.getAge());
		s2.setName("Arjun");
		System.out.println(s.getName());

		List<Integer> l1 = Arrays.asList(1,2,3,4,5);
		Stack<Integer> s1 = new Stack<>();
		l1.stream().forEach(s1::push);
	}

}

class Singleton{
	
	private static Singleton singleton ;
	
	private Singleton(){
		
	}
	
	static {
		singleton = new Singleton();
	}
	
	public static Singleton getInstance(){
		return singleton;
	}
	
	private int age;
	private String name;

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}










