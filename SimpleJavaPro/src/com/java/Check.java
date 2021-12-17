package com.java;

import java.util.HashSet;
import java.util.Set;
public class Check {
    public static void main(String[] args) {
        int balanced = shortestBalanced("azABaabZa");
        System.out.println(balanced);
        balanced = shortestBalanced("TacoCat");
        System.out.println(balanced);
        balanced = shortestBalanced("AcZCbaBz");
        System.out.println(balanced);
        System.out.println(max(909, 100));
        System.out.println(max(512, 10));
        System.out.println(max(191, 4));
        System.out.println(max(285, 20));
    }
    private static int shortestBalanced(String input) {
        int shortestStringLength = Integer.MAX_VALUE;
        for (int start = 0; start<input.length(); start++) {
            for (int end = start + 1; end <= input.length(); end++) {
                String subString = input.substring(start, end);
                if (isBalanced(subString)) {
                    shortestStringLength = Math.min(shortestStringLength,
                            end - start);
                }
            }
        }
        if (shortestStringLength == Integer.MAX_VALUE) {
            return -1;
        }
        return shortestStringLength;
    }
    private static boolean isBalanced(String subString) {
        Set<Character> lowerCase = new HashSet<>();
        Set<Character> upperCase = new HashSet<>();
        for (int i = 0; i <subString.length(); i++) {
            char character = subString.charAt(i);
            if (Character.isUpperCase(character)) {
                upperCase.add(character);
            } else {
                lowerCase.add(Character.toUpperCase(character));
            }
        }
        return lowerCase.size() == upperCase.size() &&
        lowerCase.containsAll(upperCase);
    }
    private static int max(final int n, final int k) {
        int result = 0;
        String input = String.valueOf(n);
        int remainingIncrements = k;
        while (input.length() != 0) {
            int leftMostDigit = Integer.parseInt(input.substring(0, 1));
            int numberIncrementsCanBeDone = 9 - leftMostDigit;
            int multiplier = getMultiplier(input);
            if (remainingIncrements > numberIncrementsCanBeDone) {
                remainingIncrements = remainingIncrements -
                        numberIncrementsCanBeDone;
                result = result + (leftMostDigit +
                        numberIncrementsCanBeDone) * multiplier;
            } else {
                result = result + (leftMostDigit + remainingIncrements) *
                        multiplier;
                remainingIncrements = 0;
            }
            input = input.substring(1);
        }
        return result;
    }
    private static int getMultiplier(String input) {
        if (input.length() == 3) {
            return 100;
        }
        if (input.length() == 2) {
            return 10;
        }
        return 1;
    }
}
