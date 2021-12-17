package com.java.prob;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
	
	public static void main(String args[]) {
		String str = "abalaji";
		
		Set<Character> strSet = new LinkedHashSet<Character>();
		
		char[] chars = str.toCharArray();
		
		for(char character : chars){
			strSet.add(character);
		}
		
		StringBuffer strBuff = new StringBuffer();

		for(Character ch : strSet){
			strBuff.append(ch);
		}
		
		System.out.println(strBuff);
	}
	
}
