package com.array;

/*https://www.alessiocantarella.it/codility/max-slice-sum/
* Find a maximum sum of a compact subsequence of array elements
* A non-empty array A consisting of n integers is given. A pair of integers (p, q), such that 0 ? p ? q < n, is called a slice of array A. The sum of a slice (p, q) is the total of A[p] + A[p + 1] + … + A[q].

Write a function that, given an array A consisting of n integers, returns the maximum sum of any slice of A.

For example, given array A such that: A[0] = 3, A[1] = 2, A[2] = -6, A[3] = 4, A[4] = 0, the function should return 5 because:
• (3, 4) is a slice of A that has sum 4;
• (2, 2) is a slice of A that has sum ?6;
• (0, 1) is a slice of A that has sum 5,
• no other slice of A has sum greater than (0, 1).
* */
public class MaxSliceSum {

    public static void main(String args[]){
        int[] arr = {3,2,-6,4};
        //{-2, -3, 4, -1, -2, 1, 5, -3} - Max is 7
        //{3,2,-6,10} - Max is 10
        int localMax = arr[0], absoluteMax = arr[0];
        for(int i=1;i<arr.length;i++){
            localMax = Math.max(arr[i],localMax+arr[i]);
            absoluteMax = Math.max(localMax,absoluteMax);
        }
        System.out.println(absoluteMax);
    }
}
