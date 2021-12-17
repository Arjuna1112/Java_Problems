package com.array;

public class LongestIncreasingSubsequence {

    /*The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given
     sequence such that all elements of the subsequence are sorted in increasing order. For example,
     the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.*/
    public static void main(String[] args){
        int [] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println("\nOutput ->"+findLIS(arr));
    }

    private static int findLIS(int[] arr){
        int[] LIS = new int[arr.length];
        for(int i=0;i<arr.length;i++) LIS[i]=1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]&&LIS[i]<LIS[j]+1)
                    LIS[i]=LIS[j]+1;
            }
        }
        int max = 0;
        int count =0;
        for(int i=0;i<arr.length;i++) {
            if (max < LIS[i]) max = LIS[i];
            if(count<LIS[i]){
                System.out.print(arr[i]+" ");
                count++;
            }
        }
        return max;
    }
}
