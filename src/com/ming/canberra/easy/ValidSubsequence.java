package com.ming.canberra.easy;

import java.util.List;

public class ValidSubsequence {
    public static void main(String[] args) {
        System.out.println("hello algoexpert world");

        ValidSubsequence.isValidSubsequence(null, null);
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int iArray = 0;
        int iSequence = 0;
        while (iArray < array.size())
        {
            if (array.get(iArray) == sequence.get(iSequence)){
                iSequence++;
                if (iSequence == sequence.size()){
                    return true;
                }
            }
            iArray++;
        }

        return false;
    }
}
