package com.ming.canberra.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumWaitingTime {
    public static void main(String[] args) {
        MinimumWaitingTime MinimumWaitingTime = new MinimumWaitingTime();
        System.out.println(MinimumWaitingTime.minimumWaitingTime(null));
    }

    public int minimumWaitingTime(int[] queries) {

        Arrays.sort(queries);
        int rst = 0;

        int currentSum = 0;
        for (int i = 0; i < queries.length - 1; i++){
            currentSum+=queries[i];
            rst+=currentSum;
        }

        return rst;
    }
}
