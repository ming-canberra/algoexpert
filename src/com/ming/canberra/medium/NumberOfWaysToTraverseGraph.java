package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfWaysToTraverseGraph {
    public static void main(String[] args) {
        NumberOfWaysToTraverseGraph phoneNumberMnemonics = new NumberOfWaysToTraverseGraph();
        phoneNumberMnemonics.numberOfWaysToTraverseGraph(1, 3);
    }

    /**
     *
     * O(w * h) time
     * O(w * h) space
     * */
    public int numberOfWaysToTraverseGraph(int width, int height) {
        int dp[][] = new int[height][width];
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[height - 1][width - 1];
    }
    /**
     * optimised for space
     *
     * o(w) space
    * */
    public int numberOfWaysToTraverseGraph2(int width, int height) {
        int previousRow[] = new int[width];
        int currentRow[] = new int[width];

        Arrays.fill(previousRow, 1);
        Arrays.fill(currentRow, 1);

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                currentRow[j] = currentRow[j - 1] + previousRow[j];
                previousRow[j] = currentRow[j];
            }
        }
        return currentRow[width - 1];
    }
}

