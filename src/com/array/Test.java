package com.array;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String args[]){
        int A[] = {2,3,7,10,12};
        int B[] = {1,5,7,8};
        int l1=5,l2=4;
        int max = 0, sum1=0, sum2=0;
        int x=0,y=0;

        while(x<l1 && y<l2){
            System.out.println(x+" & "+y);
            if(A[x]<B[y]) sum1+=A[x++];
            else if(A[x]>B[y]) sum2+=B[y++];
            else{
                max = (sum1>=sum2?sum1:sum2)+A[x];
                sum1=0;sum2=0;
                x++;
                y++;
            }
        }
        while(x<l1){
            sum1+=A[x];
            x++;
        }
        while(y<l2){
            sum2+=B[y];
            y++;
        }
        max+=sum1>=sum2?sum1:sum2;
        System.out.println(max);
    }
}
