package com.ming.canberra.medium;

public class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        int aa[] = new int[]{2, 4};
        NumberOfWaysToMakeChange arrayOfProducts = new NumberOfWaysToMakeChange();
        System.out.println (NumberOfWaysToMakeChange.numberOfWaysToMakeChange(7, aa));
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        if (n ==0){
            return 1;
        }
        int[][] dp = new int[denoms.length][n + 1];
        for (int i = 0; i < denoms.length; i++){
            for (int j = 1; j <= n; j++){
                if (i == 0){
                    if (j % denoms[0] == 0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = 0;
                    }
                }
                else {
                    if (j - denoms[i] >0)
                    {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - denoms[i]];
                    }
                    else if (j - denoms[i] == 0){
                        dp[i][j] = dp[i - 1][j] + 1;
                    }
                    else{
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[denoms.length - 1][n];
    }
}

