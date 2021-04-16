package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.List;

public class MaxSumIncreasingSubsequence {
    public static void main(String[] args) {

        MaxSumIncreasingSubsequence.maxSumIncreasingSubsequence(
                new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
    }

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        // Write your code here.


        return new ArrayList<List<Integer>>() {
            {
                add(List.of(10)); // Example max sum
                add(List.of(2, 3, 5)); // Example max sequence
            }
        };
    }
}

