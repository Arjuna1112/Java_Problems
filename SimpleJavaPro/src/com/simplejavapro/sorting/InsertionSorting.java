package com.simplejavapro.sorting;


public class InsertionSorting {

	public static void insertionsorting(int A[])
	{
		for(int i =1; i < A.length ; i++)
		{
			int value = A[i];
			int hole = i;
			while(hole>0 && A[hole-1]>value)
			{
				A[hole]=A[hole-1];
				hole=hole-1;
			}
			A[hole]=value;
		}
		System.out.println("Insertion sorting after sort");
		for(int i =0; i < A.length ; i++)
		{
		  System.out.println(A[i]);
		}
	}
 
}
