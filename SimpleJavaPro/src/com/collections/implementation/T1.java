package com.collections.implementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;


public abstract class T1 {
	
	/*void test(){
		NavigableMap m = new TreeMap<String,T>();
	}*/
	/*public T1(int i,int j){
		
	}*/
	
	public abstract void mul();
	
	public T1(){
		System.out.println("I am T1 int ...");
	}
	
	public T1(double a){
		System.out.println("I am T1 Double "+a);
	}
	
	static {
		System.out.println("I am static of T1");
	}
	
	{
		System.out.println("I am default of T1");
	}
	
	protected void add() throws FileNotFoundException{
		System.out.println("Main Class");
	}
	
	public static void sub(){
		System.out.println("Main Class Static");
	}
	
	/*public class Address{
		
	}*/
	
	/*public static void main(String args[]){
		Thread t = new Thread(new T1());
		t.run();
		t.start();
		System.out.println("End Of Method.");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run");
		//throw new RuntimeException("Problem");
	}*/
	
	public float aMethod(float a, float b) throws NullPointerException{
		return 0;
	}
	
	/*int arr[][] = new int[5][5];
	int[] arr1[] = new int[5][5];
	int[] arr2 = new int[5][];
	int[] arr3 = new int[][5];*/
	
	static int i =5;
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		/*Pattern p = Pattern.compile("a+b?c*");
		Matcher m = p.matcher("ab");
		boolean b = m.matches();
		System.out.println(b);
		
		List list = new ArrayList();
		list.add(new Integer(12).intValue());
		list.add(new Integer(13));
		list.add(new Integer(12));
		Arrays.sort(list.toArray());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}*/
		
		/*List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean b : l) {
            System.out.println(b.getName());
        }
        T2<Integer> t = new T2<Integer>();*/
		
		
	}
	
	public static void testMethod(){
		
	}
	
}

