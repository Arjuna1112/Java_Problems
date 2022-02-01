package com.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountOfWords {

    public static void main(String args[]){
        List<Integer> numList= Arrays.asList(1,2,1,3,4,2,5,6,5,8,6,9,7,9);
        Map<Integer,Long> outMap = numList.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
        outMap.forEach((key,value)-> System.out.println(key+" - "+value));
        List<String> strList = Arrays.asList("arjun","ravi","raju","arjun","ravi","ramu");
        Map<String,Long> outStr = strList.stream().collect(
                Collectors.groupingBy(Function.identity(),Collectors.counting()));
        outStr.forEach((key,value)-> System.out.println(key+" - "+value));
        System.out.println("--- Legacy Approach ---");
        Map<String,Long> legOut = new HashMap<>();
        strList.forEach(str-> {
            if (legOut.containsKey(str)) {
                legOut.put(str, legOut.get(str) + 1);
            } else {
                legOut.put(str, 1l);
            }
        });
        System.out.println(legOut);
    }
}
