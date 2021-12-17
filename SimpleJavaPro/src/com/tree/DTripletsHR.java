package com.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DTripletsHR {
    public static void main(String args[]){
        long[] longs = {42,87,3,27,29,40,12,3,69,9,57,60,33,99,78,16,35,97,26,12,67,10,33,79,49,79,21,67,72,93,36,85,45,28,91,94,57,1,53,8,44,68,90,24,96,30,22,66,49,24};
        System.out.println(solve(longs));
    }
    public static class Triplets {
        long[] lSmaller, rLarger, treeArray;
        int[] dscArray, lFlags, rFlags;
        int size, count = 0;

        Triplets(int aSize, long[] inputArray) {
            size = aSize;
            lSmaller = new long[size];
            rLarger = new long[size];
            dscArray = new int[size];
            long[] tmpArray = Arrays.copyOf(inputArray, inputArray.length);
            Arrays.sort(tmpArray);
            HashMap<Long, Integer> tmpMap = new HashMap<>(size);
            for (int i = 0; i < size; i++) {
                if (!tmpMap.containsKey(tmpArray[i])) {
                    count++;
                    tmpMap.put(tmpArray[i], count);
                }
            }
            count++;
            treeArray = new long[count];
            lFlags = new int[count];
            rFlags = new int[count];
            for (int i = 0; i < size; i++) {
                dscArray[i] = tmpMap.get(inputArray[i]);
            }

        }

        void update(int idx) {
            while (idx < count) {
                treeArray[idx]++;

                idx += (idx & -idx);
            }
        }

        long read(int index) {
            int sum = 0;
            while (index > 0) {
                sum += treeArray[index];
                index -= (index & -index);
            }
            return sum;
        }

        void countLeftSmaller() {
            Arrays.fill(treeArray, 0);
            Arrays.fill(lSmaller, 0);
            Arrays.fill(lFlags, 0);
            for (int i = 0; i < size; i++) {
                int val = dscArray[i];
                lSmaller[i] = read(val - 1);
                if (lFlags[val] == 0) {
                    update(val);
                    lFlags[val] = i + 1;
                } else {
                    lSmaller[i] -= lSmaller[lFlags[val] - 1];
                }
            }
        }

        void countRightLarger() {

            Arrays.fill(treeArray, 0);
            Arrays.fill(rLarger, 0);
            Arrays.fill(rFlags, 0);
            for (int i = size - 1; i >= 0; i--) {
                int val = dscArray[i];
                rLarger[i] = read(count - 1) - read(val);
                if (rFlags[val] == 0) {
                    update(val);
                    rFlags[val] = i + 1;
                }
            }
        }

        long countTriplets() {
            long sum = 0;
            for (int i = 0; i < size; i++) {
                sum += lSmaller[i] * rLarger[i];
            }
            return sum;
        }
    }

    // Complete the solve function below.
    static long solve(long[] d) {
        int n = d.length;
        Triplets sol = new Triplets(n, d);
        sol.countLeftSmaller();
        sol.countRightLarger();
        return sol.countTriplets();
    }
}
