package com.ming.canberra.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] res = TwoNumberSum.twoNumberSum(null, 1);

        for (int n : res){
            System.out.println(n);
        }
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.

        Set set =  new HashSet<Integer>();
        for (int n : array){
            set.add(n);
        }

        for (int n : array){
            if (set.contains(targetSum - n) && n != targetSum - n){
                return new int[]{n, targetSum - n};
            }
        }

        return new int[0];
    }
}
