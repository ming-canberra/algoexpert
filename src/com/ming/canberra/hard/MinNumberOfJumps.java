package com.ming.canberra.hard;

import java.util.Arrays;

public class MinNumberOfJumps {
    public static void main(String[] args) {
        MinNumberOfJumps.minNumberOfJumps(null);
    }
    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static int minNumberOfJumps(int[] array) {
        int[] dp = new int[array.length];
        Arrays.fill(dp,0);
        for (int i = 0; i < array.length - 1; i++){
            for (int j = i + 1; j <= i + array[i] && j < array.length; j++)
            {
                if (dp[j] == 0){
                    dp[j] = dp[i] + 1;
                }
                else{
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[array.length - 1];
    }
}

