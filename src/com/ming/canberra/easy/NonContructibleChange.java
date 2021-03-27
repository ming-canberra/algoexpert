package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NonContructibleChange {
    public static void main(String[] args) {
        NonContructibleChange sortedSquaredArray = new NonContructibleChange();
        int res = sortedSquaredArray.nonConstructibleChange(null);

        System.out.println(res);

    }

    public int nonConstructibleChange(int[] coins) {
        if (coins == null || coins.length == 0){
            return 1;
        }

        Arrays.sort(coins);

        if (coins[0] != 1){
            return 1;
        }
        int sum = 1;
        for (int i = 1; i < coins.length; i++){
            if (coins[i] >sum + 1){
                return sum + 1;
            }
            sum+=coins[i];
        }

        return sum + 1;
    }
}
