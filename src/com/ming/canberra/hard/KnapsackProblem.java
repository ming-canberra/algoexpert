package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        KnapsackProblem.knapsackProblem(input, 10);
    }
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int dp[][] = new int[items.length + 1][capacity + 1];
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++) {
                if (j < items[i - 1][1]){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i - 1][1]] + items[i - 1][0]);
                }
            }
        }
        int i = dp[items.length][capacity];
        return generateResult(items, dp);
    }
    private static List<List<Integer>> generateResult(int[][] items, int dp[][]){
        List<Integer> maxValueList = new ArrayList<Integer>();
        maxValueList.add(dp[dp.length - 1][dp[0].length - 1]);
        int maxValue = maxValueList.get(0);

        int rowIndex = dp.length - 1;
        int columnIndex = dp[0].length - 1;
        List<Integer> indexesList = new ArrayList<Integer>();

        while (maxValue != 0){
            if (dp[rowIndex][columnIndex] != dp[rowIndex - 1][columnIndex]){
                indexesList.add(rowIndex - 1);
                maxValue-=items[rowIndex - 1][0];
                columnIndex = columnIndex - items[rowIndex - 1][1];
            }
            rowIndex--;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(maxValueList);
        result.add(indexesList);
        return result;
    }
}

