package com.logics.programs;

public class Min_Path_Square_Matrix {
	
	static int counter;
	
	public static void main(String args[]){
		System.out.println("Total Number Of Path.."+path(3,3));
		System.out.println("Total Number Of Combination.."+combinationOfParaenthesis("",3,3));
	}
	
	public static int  path(int x,int y){
		if(x==1||y==1) return 1;
		return path(x-1,y)
				+path(x,y-1);
	}
	
	public static int combinationOfParaenthesis(String s, int open, int close){
		if(open>close){
			return -1;
		}
		if(open==0&&close==0){
			counter++;
			System.out.println(s+",");
			return 1;
		}
		if(open>0){
			combinationOfParaenthesis(s+"(", open-1, close);
		}
		if(close>0){
			combinationOfParaenthesis(s+")", open, close-1);
		}
		return counter;
	}

}
