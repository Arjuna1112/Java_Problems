package com.array;
/*
* Search an element in a sorted and rotated array
* */
public class KeyInSortedRotatedArray {
    static int count = 0;
    public static void main(String args[]){
        int[] arr = {30,40,50,60,70,80,10,20,25,28};
        //{70,80,10,20,30,40,50,60};
        System.out.println(findIndex(arr,0,arr.length-1,10));
        System.out.println(count);
    }

    private static int findIndex(int[] arr, int start, int end, int key){
        count++;
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(arr[mid]==key) return mid;
        if(arr[start]<=arr[mid]){
            if(key>=arr[start]&&key<=arr[mid]) return findIndex(arr,start,mid-1,key);
            return findIndex(arr,mid+1,end,key);
        }
        if(key>=arr[mid]&&key<=arr[end]) return findIndex(arr,mid+1,end,key);
        return findIndex(arr,start,mid-1,key);
    }
}
