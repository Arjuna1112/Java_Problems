package com.array;

/**
 * Given an array of untangled necklaces with beads with each bead pointing to the next one,
 * Find the longest necklace with the highest number of beads
 * For example, array A = {5,4,0,3,1,6,2}
 * the function should return 4, because the longest necklace is the one containing 4 beads, numbers {0,5,6,2} because
 * A[0] = 5 -> A[5] = 6 -> A[6] = 2 -> A[2] = 0 : Total 4
 * A[1] = 4 -> A[4] = 1 : Total 2
 * A[3] = 3 : Total 1 so max is 4
 */
public class LongestNecklaceBeads {
    public static void main(String[] args){
        int[] arr = {5,4,0,3,1,6,2};
        boolean[] visited = new boolean[arr.length];
        int finalCount = 0;
        for(int i=0;i<arr.length;i++){
            if(visited[i]) continue;
            visited[i]=true;
            int j = arr[i];
            int count = 1;
            while (i!=j){
                visited[j]=true;
                count++;
                j=arr[j];
            }
            System.out.println("Count : "+count);
            if(finalCount<count)finalCount=count;
        }
        System.out.println(finalCount);
    }
}
