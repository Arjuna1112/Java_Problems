package com.simplejavapro.sorting;


public class SelectionSorting {

	public static void selectionsorting(int A[])
	{
		for(int i =0; i < A.length-1 ; i++)
		{
			int imin= i;
			for(int j=i+1;j<A.length;j++)
			{
				if(A[j]<A[imin])
				{
					imin=j;
				}
			}
			int temp = A[i];
			A[i] = A[imin];
			A[imin] = temp;
		}
		System.out.println("Selection sorting after sort");
		for(int i =0; i < A.length ; i++)
		{
		  System.out.println(A[i]);
		}
	}
 
}
