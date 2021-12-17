package com.sorting;


public class QuickSorting {

	public static void quicksorting(int A[])
	{
		int start = 0;
		int end = A.length-1;
		quickSort(A,start,end);
	}
	
	public static void quickSort(int A[], int start, int end)
	{
		if(start<end)
		{
			int pIndex=partitionIndex(A, start, end);
			quickSort(A,start,pIndex-1);
			quickSort(A,pIndex+1, end);
		}
		System.out.println("Quick sorting after sort");
		for(int i =0; i < A.length ; i++)
		{
		  System.out.println(A[i]);
		}
	}
	
	public static int partitionIndex(int A[], int start, int end)
	{
		int pIndex = start;
		int pivot = A[end];
		 for (int i =start; i < end ; i++ )
		 {
			 if(A[i]<=pivot)
			 {
				 int temp=A[i];
				 A[i]=A[pIndex];
				 A[pIndex]=temp;
				 pIndex++;
			 }
		 }
		 int temp=A[end];
		 A[end]=A[pIndex];
		 A[pIndex]=temp;
		return pIndex;
	}
	
}
