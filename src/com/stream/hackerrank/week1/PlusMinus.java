package com.stream.hackerrank.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusMinus {

    public static void main(String args[]){
        List<Integer> arr = Arrays.asList(1,2,3,4,5,6,7);
        System.out.printf("%.6f",(double)arr.stream().filter(integer -> integer>0).count()/ arr.size());
        System.out.println();
        System.out.printf("%.6f",(double)arr.stream().filter(integer -> integer<0).count()/ arr.size());
        System.out.printf("%.6f",(double)arr.stream().filter(integer -> integer==0).count()/ arr.size());
    }
}
