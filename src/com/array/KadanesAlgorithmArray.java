package com.array;

/*
* Kadane’s Algorithm can be viewed both as a greedy and DP. As we can see that we are keeping a running sum of integers
*  and when it becomes less than 0, we reset it to 0 (Greedy Part). This is because continuing with a negative sum is way
*  more worse than restarting with a new range. Now it can also be viewed as a DP, at each stage we have 2 choices:
* Either take the current element and continue with previous sum OR restart a new range. These both choices are
* being taken care of in the implementation.
* Time Complexity: O(n)
* Auxiliary Space: O(1)
* */
public class KadanesAlgorithmArray {

    public static void main(String[] args) {
        int[] a = {-2,-3,4,-1,-2,1,5,-3};
        maxSumSubArray(a);
    }

    private static void maxSumSubArray(int[] a){
        int currSum = 0, maxSum = Integer.MIN_VALUE;
        int start=0, end=0;
        for(int i=0;i<a.length;i++){
            currSum+=a[i];
            if(maxSum<currSum){
                maxSum=Math.max(maxSum,currSum);
                end=i;
            }
            if(currSum<0){
                currSum=0;
                start=i+1==a.length?i:i+1;
            }
        }
        System.out.println(maxSum);
        System.out.println(start+" && "+end);
        for(int i=start;i<=end;i++){
            System.out.print(a[i]+"->");
        }
    }
}
