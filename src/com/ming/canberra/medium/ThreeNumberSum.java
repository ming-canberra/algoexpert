package com.ming.canberra.medium;

import java.util.*;

public class ThreeNumberSum {
    public static void main(String[] args) {
        ThreeNumberSum.threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        Set<Integer> originalSet = new HashSet<>();
        for (int i = 0; i < array.length; i++){
            originalSet.add(array[i]);
        }
        List<Integer[]> result = new ArrayList<Integer[]>();
        for (int i = 0; i < array.length; i++){
            originalSet.remove(array[i]);
                Set<Integer> set = new HashSet<>();
                set.addAll(originalSet);
                for (int j = i + 1; j < array.length; j++) {
                    set.remove(array[j]);
                    int currentTarget = targetSum - array[i] - array[j];
                    if (set.contains(currentTarget)) {
                        result.add(new Integer[]{array[i], array[j], currentTarget});
                    }
                }
        }
        return result;
    }
}

