package com.array;

import java.util.Stack;

/*
* Maximum product of indexes of next greater on left and right
* Input : 1 1 1 1 0 1 1 1 1 1
Output : 24
For {1, 1, 1, 1, 0, 1, 1, 1, 1, 1} all element are same except 0. So only for zero their exist
greater element and for others it will be zero. for zero, on left 4th element is closest and greater
than zero and on right 6th element is closest and greater. so maximum
product will be 4*6 = 24.
Input : 5 4 3 4 5
Output : 8
For {5, 4, 3, 4, 5}, L[] = {0, 1, 2, 1, 0} and R[]
= {0, 5, 4, 5, 0},
LRProduct = {0, 5, 8, 5, 0} and max in this is 8.
*/

public class MaxIndexProduct {

    public static void main(String args[]){
        int[] input = {5,4,3,4,5};
        findMaxIndexProduct(input);
    }

    private static void findMaxIndexProduct(int[] input){
        long[] ouptut = new long[input.length];
        findLeftGreaterIndex(input,ouptut);
        findRightGreaterIndex(input,ouptut);
        long max = 2500100000l;
        for(long i:ouptut){
            if(max<i)max=i;
        }
        System.out.println(max);
    }

    static void findLeftGreaterIndex(int[] input, long[] output){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        output[0]=0;
        for(int i=1;i<input.length;i++){
            while (!stack.isEmpty()&&input[stack.peek()]<=input[i])
                stack.pop();
            output[i]=(stack.isEmpty())?0:stack.peek()+1;
            stack.push(i);
        }
    }

    static void findRightGreaterIndex(int[] input, long[] output){
        Stack<Integer> stack = new Stack<>();
        stack.push(input.length-1);
        output[input.length-1] = 0;
        for(int i=input.length-2;i>=0;i--){
            while (!stack.isEmpty()&&input[stack.peek()]<=input[i])
                stack.pop();
            output[i]=(stack.isEmpty())?0:(stack.peek()+1)*output[i];
            stack.push(i);
        }
    }
}
