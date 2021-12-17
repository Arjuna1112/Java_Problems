package com.stream;

/*
1. In java, we can not extend 2 class because if we both class has same method definition then the extended class doesn't know
which method to invoke (Diamond Problem) so multiple inheritance not possible in java
2. Interface are used to expose just skeleton not the implementation, also it solves diamond problem
3. In java 7 we can have only definition of method in interface,but in java 8 we can have default and static method along with
implementation inside interface
4. If any class implements interface need not override default method until if it has implemented 2 or more interface
which has same method with default type
5. Lambda Expression - replacement of implementation of method defined in functional interface
(it can have only 1 method definition)
6. Similar to this foreach of collections uses consumer interface (Functional Interface) accept method
 */

import java.util.Arrays;
import java.util.List;

public class LambdaExpressionExplained {

    public static void main(String args[]){
        //normal way of invoking method in interface
        Common common = new TV();
        common.display();
        //invocation using anonymous class
        Common anonymous = new Common() {
            @Override
            public void display() {
                System.out.println("By Anonymous class");
            }
        };
        anonymous.display();
        //using lambda expression
        Common lambda = ()-> System.out.println("By Lambda Expression");
        lambda.display();
        //lambda expression in forEach of collections
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.forEach((i)-> System.out.print(i));
    }

}

interface Common{
    void display();

    default void add(){
        System.out.println("Addition");
    }
}

class TV implements Common{
    @Override
    public void display() {
        System.out.println("Normal Invocation");
    }
}