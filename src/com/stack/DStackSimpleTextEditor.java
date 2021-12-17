package com.stack;

import java.util.*;
import java.util.stream.Collectors;

public class DStackSimpleTextEditor {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        Stack<String> stack = new Stack<>();
        String str = "";
        for(int i=0;i<q;i++){
            int opr = scanner.nextInt();
            if(opr==1) {
                str+=scanner.next();
                stack.push(str);
            }
            else if(opr==2){
                str = str.substring(0,str.length()-scanner.nextInt());
                stack.push(str);
            }
            else if(opr==3) System.out.println(str.charAt(scanner.nextInt()-1));
            else if(opr==4){
                stack.pop();
                if(!stack.isEmpty()) str = stack.peek();
            }
        }
    }
}
