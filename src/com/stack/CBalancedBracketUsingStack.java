package com.stack;

import java.util.Stack;

public class CBalancedBracketUsingStack {

    public static void main(String args[]){
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[()()]]}}"));
        System.out.println(usingStack("{{[[([])]]}}"));
    }

    public static String isBalanced(String s) {
        // Write your code here
        if(s.length()==0) return "NO";
        while(s.contains("()")||
                s.contains("[]")||
                    s.contains("{}")){
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
