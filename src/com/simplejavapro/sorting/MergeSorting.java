package com.simplejavapro.sorting;


public class MergeSorting {

	public static void mergesorting(int A[])
	{
		int n = A.length;
		if(n<2) return;
		int mid = n/2;
		int left[] = new int[mid];
		int right[] = new int[n-mid];
		for(int i =0 ;i<mid ; i++)
		{
			left[i]=A[i];
		}
		for(int i =mid ;i<n ; i++)
		{
			right[i-mid]=A[i];
		}
		mergesorting(left);
		mergesorting(right);
		merge(left, right, A);
		System.out.println("Merge sorting after sort");
		for(int i =0; i < A.length ; i++)
		{
		  System.out.println(A[i]);
		}
	}
	
	public static void merge(int left[], int right[], int A[])
	{
		int i = 0,j =0, k=0; 
		while(i<left.length&&j<right.length)
		{
			if(left[i]<=right[j])
			{
				A[k]=left[i];
				i++;
			}
			else
			{
				A[k]=right[j];
				j++;
			}
			k=k+1;
		}
		while(i<left.length)
		{
			A[k]=left[i];
			i++;
			k++;
		}
		while(j<right.length)
		{
			A[k]=right[j];
			j++;
			k++;
		}
	}
 
}
