package com.ming.canberra.hard;

import java.util.Arrays;

public class MinRewards {
    public static void main(String[] args) {
        int result = MinRewards.minRewards(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
            System.out.println(result);
    }

    public static int minRewards(int[] scores) {
        // Write your code here.
        if (scores.length == 1){
            return 1;
        }
        else if (scores.length == 2){
            return 3;
        }

        return 1;
    }
}

