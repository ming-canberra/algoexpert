package com.ming.canberra.medium;

public class MaxSubsetSumNoAdjacent {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3};
        MaxSubsetSumNoAdjacent arrayOfProducts = new MaxSubsetSumNoAdjacent();
        System.out.println (MaxSubsetSumNoAdjacent.maxSubsetSumNoAdjacent(aa));
    }

    public static int maxSubsetSumNoAdjacent2(int[] array) {
        // Write your code here.
        if (array == null || array.length == 0){
            return 0;
        }

        if (array.length == 1){
            return array[0];
        }

        int[] dp = new int[array.length];// dp store
        dp[0] = array[0];
        for (int i = 1;i < array.length; i++){
            if (i == 1){
                dp[i] = Math.max(array[0], array[1]);
            }
            else{
                dp[i] = Math.max(dp[i-1], dp[i-2] + array[i]);
            }
        }

        return dp[array.length - 1];
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        // Write your code here.
        if (array == null || array.length == 0){
            return 0;
        }

        if (array.length == 1){
            return array[0];
        }


        int dp0 = array[0];
        int dp1 = Math.max(array[0], array[1]);
        if (array.length == 2){
            return dp1;
        }

        int dp2;
        for (int i = 2; i < array.length; i++){
            dp2 = Math.max(dp1, dp0 + array[i]);
            if (i == array.length - 1){
                return dp2;
            }
            else{
                dp0 = dp1;
                dp1 = dp2;
            }
        }

        return 0;
    }
}

