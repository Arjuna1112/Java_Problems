package com.java;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

public class BinaryGap {

    public static void main(String args[]){
        int number = 32;
        Stack<Integer> binaryStack = new Stack<>();
        while(number>0){
            binaryStack.push(number%2);
            number = number/2;
        }
        int gap = 0, maxGap =0;
        while (!binaryStack.isEmpty()){
            if(binaryStack.peek()==0) gap++;
            else {
                if (gap > maxGap)
                    maxGap = gap;
                gap = 0;
            }
            binaryStack.pop();
        }
        System.out.println("-----");
        System.out.println(maxGap);
    }
}
