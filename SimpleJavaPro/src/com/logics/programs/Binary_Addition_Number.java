package com.logics.programs;

public class Binary_Addition_Number {

	public static void main(String[] args) {
		System.out.println(addBinaryNumbers("100000", "10"));
	}
	
	public static String addBinaryNumbers(String num1, String num2) {
		int firstNum = num1.length()-1;
		int secondNum = num2.length()-1;
		StringBuffer buf = new StringBuffer();
		int carry=0;
		while(firstNum>=0 || secondNum>=0){
			int sum = carry;
			if(firstNum>=0){
				sum+=num1.charAt(firstNum)-'0';
				firstNum--;
			}
			if(secondNum>=0){
				sum+=num2.charAt(secondNum)-'0';
				secondNum--;
			}
			carry = sum>>1;
			sum= sum & 1;
			buf.append(sum==0 ? '0':'1');
		}
		if(carry>0){
			buf.append('1');
		}
		buf.reverse();
		return buf.toString();
	}

}
