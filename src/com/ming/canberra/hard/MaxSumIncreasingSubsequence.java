package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSumIncreasingSubsequence {
    public static void main(String[] args) {
        List<List<Integer>> result = MaxSumIncreasingSubsequence.maxSumIncreasingSubsequence(
                new int[]{-1, 1});
        System.out.println(result);
    }
    private static Integer NO_PREVIOUS_LINK = -1;
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        int[][] helperArray = new int[array.length][2]; // first element stores the max sum of the subsequence that ends
        // with the current index. second element stores the index that links to previous item to this array that
        // generates this max sum
        helperArray[0] = new int[]{array[0], NO_PREVIOUS_LINK};
        int maxIndexForSum = 0;
        for (int i = 1; i < helperArray.length; i++){
            int maxIndex = NO_PREVIOUS_LINK;
            for (int j = 0; j < i; j++){
                if (array[i] > array[j]){
                    if (maxIndex == NO_PREVIOUS_LINK){
                        if (helperArray[j][0] > 0){
                            maxIndex = j;
                        }
                    }
                    else if (helperArray[maxIndex][0] < helperArray[j][0]){
                        maxIndex = j;
                    }
                }
            }
            if (maxIndex == NO_PREVIOUS_LINK){
                helperArray[i] = new int[]{array[i], maxIndex};
            }
            else{
                helperArray[i] = new int[]{helperArray[maxIndex][0] + array[i], maxIndex};
            }
            if (helperArray[i][0] > helperArray[maxIndexForSum][0]){
                maxIndexForSum = i;
            }
        }
        int maxSum = helperArray[maxIndexForSum][0];
        List<Integer> indexesToReturn = new ArrayList<Integer>();
        indexesToReturn.add(array[maxIndexForSum]);
        int previousIndex = helperArray[maxIndexForSum][1];
        while (previousIndex != NO_PREVIOUS_LINK){
            indexesToReturn.add(array[previousIndex]);
            previousIndex = helperArray[previousIndex][1];
        }
        Collections.reverse(indexesToReturn);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> resultSum = new ArrayList<Integer>();
        resultSum.add(maxSum);
        result.add(resultSum);
        result.add(indexesToReturn);
        return result;
    }
}