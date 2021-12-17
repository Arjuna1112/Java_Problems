package com.java;

public class PermuatatioOfString {

	public static void main(String[] args) {

		String a = "ABC";
		char[] ch = a.toCharArray();
		permute(ch, 0, a.length());
	}
	
	private static void permute(char[] a, int start, int end){
		if(start==end){
			System.out.println(a);
		}else{
			for(int i = start; i<end; i++){
				char temp = a[start];
				a[start] = a[i];
				a[i]=temp;
				permute(a, start+1, end);
				temp = a[start];
				a[start] = a[i];
				a[i]=temp;
			}
		}
	}
	
}
