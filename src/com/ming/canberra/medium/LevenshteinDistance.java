package com.ming.canberra.medium;

public class LevenshteinDistance {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println (LevenshteinDistance.levenshteinDistance("biting", "mitten"));
    }

    public static int levenshteinDistance(String original, String target) {
        int[][] dp = new int[original.length() + 1][target.length() + 1];
        for (int i = 0; i < dp.length; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j < dp[0].length; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i <= original.length(); i++){
            for (int j = 1; j <= target.length(); j++){
                if (original.charAt(i - 1) == target.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[original.length()][target.length()];
    }
}

