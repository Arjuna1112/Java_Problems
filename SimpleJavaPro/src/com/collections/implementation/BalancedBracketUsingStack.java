package com.collections.implementation;

import com.collections.implementation.MyQueue;

import java.util.Queue;
import java.util.Stack;

public class BalancedBracketUsingStack {

    public static void main(String args[]){
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[()()]]}}"));
        System.out.println(usingStack("{{[[([])]]}}"));
    }

    public static String isBalanced(String s) {
        // Write your code here
        if(s.length()==0) return "NO";
        int n = -1;
        while(s.length()!=n){
            n = s.length();
            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
        }
        if(s.length()==0) return "YES";
        return "NO";
    }

    private static String usingStack(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            if(x=='['||x=='('||x=='{') stack.push(x);
            else{
                if(stack.isEmpty()) return "NO";
                char y = stack.pop();
                if(!((x==']' && y=='[')
                || (x==')' && y=='(')
                || (x=='}' && y=='{'))) return "NO";
            }
        }
        return "YES";
    }
}
