package com.java;

public class Text_Dollar_Coding {
	
	private static final String[] specialCase ={
		""," thousand"," million"};
	
	private static final String[] tenplace ={
		""," ten"," twenty"," thirty"," fourty"," fifty"," sixty"," seventy"," eighty"," ninghty"};
	
	private static final String[] numplace ={
		""," one"," two"," three"," four"," five"," six"," seven"," eight"," nine"," ten",
		" eleven"," twelve"," thirteen"," fourteen"," fifeen"," sixteen"," seventeen"," eighteen"," ninghteen"};
	
	public static void main(String args[]){
		System.out.println(convertNumToWord(1234567));
	}
	
	private static String convertNumToWord(int number){
		String current="",prefix="";
		int place=0;
		if(number==0) return "zero";
		if(number<0){
			number=-number;
			prefix="negative";
		}
		do{
			int n = number%1000;
			if(n!=0){
				String s = convertLessThanThousand(n);
				current = s+specialCase[place]+current;
			}
			place++;
			number/=1000;
		}while(number>0);
		
		return (prefix+current).trim();
	}
	
	private static String convertLessThanThousand(int number){
		String current="";
		if(number%100<20){
			current=numplace[number%100];
			number=number/100;
		}else{
			current = numplace[number%10];
			number=number/10;
			
			current = tenplace[number%10]+current;
			number=number/10;
		}
		if(number==0) return current;
		return numplace[number]+" hundread"+current;
	}
	
}
