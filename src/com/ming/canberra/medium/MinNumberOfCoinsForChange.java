package com.ming.canberra.medium;

public class MinNumberOfCoinsForChange {
    public static void main(String[] args) {
        int aa[] = new int[]{1,5,10};
        MinNumberOfCoinsForChange arrayOfProducts = new MinNumberOfCoinsForChange();
        System.out.println (MinNumberOfCoinsForChange.minNumberOfCoinsForChange(7, aa));
    }
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        if (n == 0){
            return 0;
        }
        int[][] dp = new int[denoms.length][n + 1];

        for (int i = 0; i < dp[0].length; i++){
            if (i % denoms[0] == 0){
                dp[0][i] = i / denoms[0];
            }
            else{
                dp[0][i] = -1;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int notUsingNewCoin = dp[i - 1][j];
                int usingNewCoin;
                if (j - denoms[i]>=0){
                    if (dp[i][j - denoms[i]] == -1){
                        usingNewCoin = -1;
                    }
                    else {
                        usingNewCoin = dp[i][j - denoms[i]] + 1;
                    }
                }
                else{
                    usingNewCoin = -1;
                }
                if (notUsingNewCoin == -1 && usingNewCoin == -1){
                    dp[i][j] = -1;
                }
                else if (notUsingNewCoin == -1){
                    dp[i][j] = usingNewCoin;
                }
                else if (usingNewCoin == -1){
                    dp[i][j] = notUsingNewCoin;
                }
                else{
                    dp[i][j] = Math.min(notUsingNewCoin, usingNewCoin);
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}

