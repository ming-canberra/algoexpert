package com.ming.canberra.hard;

public class MaximumSumSubmatrix {
    public static void main(String[] args) {
        MaximumSumSubmatrix MaximumSumSubmatrix = new MaximumSumSubmatrix();

    }
    // bruteforce time O(m * n * size * size)
    // optimal time complexity O(m*n)
    public int maximumSumSubmatrix(int[][] matrix, int size) {
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i - 1][j] + dp [i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int currentSum = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = size; i <= m; i++){
            for (int j = size; j <= n; j++) {
                int tempSum = dp[i][j] + dp[i - size][j - size] - dp[i - size][j] - dp[i][j - size];
                currentSum = Math.max(currentSum, tempSum);
            }
        }
        return currentSum;
    }
}

