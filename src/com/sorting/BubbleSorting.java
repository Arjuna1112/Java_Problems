package com.sorting;


public class BubbleSorting {

	public static void bubblesorting(int A[])
	{
		for(int i =0; i < A.length-1 ; i++)
		{
			int flag=0;
			for(int j=0;j<A.length-i-1;j++)
			{
				if(A[j]>A[j+1])
				{
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
					flag=1;
				}
			}
			if(flag==0){
				break;
			}
		}
		System.out.println("Bubble sorting after sort");
		for(int i =0; i < A.length ; i++)
		{
		  System.out.println(A[i]);
		}
	}
 
}
