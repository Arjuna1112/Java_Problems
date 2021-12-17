package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EWaiterHackerRank {

    public static void main(String args[]){
        int[] input = {2,3,4,5,6,7};
        int noOfItr = 3;
        findTheOrderOfPlatesCollected(input,noOfItr);
    }

    private static void findTheOrderOfPlatesCollected(int input[],int noOfItr){
        //fetch list of prime number for noOfItr
        Stack<Integer> inputStack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        int prime = 2;
        for(int i=0;i<input.length;i++) inputStack.push(input[i]);
        for(int i=0;i<noOfItr;i++){
            Stack<Integer> a = new Stack<>();
            Stack<Integer> b = new Stack<>();
            while(!inputStack.isEmpty()){
                if(inputStack.peek()%prime==0) b.push(inputStack.pop());
                else a.push(inputStack.pop());
            }
            inputStack=a;
            while (!b.isEmpty()) answer.add(b.pop());
            prime = nextPrime(prime);
        }
        while (!inputStack.isEmpty()) answer.add(inputStack.pop());
        System.out.println(answer);
    }

    private static boolean isPrime(int num){
        return IntStream.rangeClosed(2,num/2).noneMatch(i->num%i==0);
    }

    private static int nextPrime(int num){
        for(int i=num+1;;i++) if(isPrime(i)) return i;
    }


}
