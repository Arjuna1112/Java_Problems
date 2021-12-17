package com.stream.hackerrank.week1;

import java.util.*;
import java.util.stream.Collectors;

public class MiniMaxSum {

    public static void main(String args[]){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.print(list.stream().sorted(Comparator.naturalOrder()).
                limit(list.size()-1).collect(Collectors.summingLong(Integer::intValue))
        + " "+
                list.stream().sorted(Comparator.reverseOrder()).limit(list.size()-1)
                        .collect(Collectors.summingLong(Integer::intValue)));

    }
}
