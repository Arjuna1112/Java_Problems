package com.sorting;


public class HeapSorting {
	
	public static void heapSorting(int A[])
	{
		int k = 0;
		for(int i=0;i<A.length;i++)
		{
			k++;
			int index=i;
			while(A[index/2]<A[index] && (index/2)!=0)
			{
				int temp=A[index/2];
				A[index/2]=A[index];
				A[index]=temp;
				index=index/2;
			}
		}
		System.out.println("Array to be sorted by Heap sorting");
		for(int i =0; i < A.length ; i++)
		{
		  System.out.print("| "+A[i]);
		}
		/*while(k>0)
		{
			int temp=A[1];
			A[1]=A[k];
			A[k]=temp;
			for(int i=0;i<k;i++)
			{
				int index=i;
				while(A[index/2]>A[index] && (index/2)!=0)
				{
					int temp2=A[index/2];
					A[index/2]=A[index];
					A[index]=temp2;
					index=index/2;
				}
			}
			k--;
		}
		System.out.println("Heap sorting after sort");
		for(int i =0; i < A.length ; i++)
		{
		  System.out.println(A[i]);
		}*/
	}
	
}
