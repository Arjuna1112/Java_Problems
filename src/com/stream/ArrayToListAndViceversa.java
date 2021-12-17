package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToListAndViceversa {

    public static void main(String args[]){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        int[] intArr = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.stream(intArr).forEach(System.out::println);
        list=Arrays.stream(intArr).boxed().collect(Collectors.toList());
        System.out.println(list);

        List<Long> longList = Arrays.asList(1l,2l,3l,4l,5l,6l);
        long[] longArr = longList.stream().mapToLong(Long::longValue).toArray();
        Arrays.stream(longArr).forEach(System.out::println);
        longList = Arrays.stream(longArr).boxed().collect(Collectors.toList());
        System.out.println(longList);
    }
}
