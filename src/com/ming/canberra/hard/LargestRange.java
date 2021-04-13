package com.ming.canberra.hard;

import java.util.Arrays;

public class LargestRange {
    public static void main(String[] args) {
        int[] result = LargestRange.largestRange(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
            System.out.println(result[0] + " " + result[1]);
    }

    public static int[] largestRange(int[] array) {
        Arrays.sort(array);
        int startRange = array[0];
        int endRange = array[0];
        int maxRange = 1;
        Integer currentStart = null;
        Integer currentEnd = null;
        Integer currentMax = null;
        for (int i = 0; i < array.length; i++){
            if (i == 0){
                currentStart = array[i];
                currentEnd = array[i];
                currentMax = 1;
            }
            if (i == array.length - 1) {
                if (array[i] == currentEnd + 1) {
                    currentMax++;
                    currentEnd++;
                }
                if (currentMax > maxRange) {
                    maxRange = currentMax;
                    startRange = currentStart;
                    endRange = currentEnd;
                }
            }
            else {
                if (array[i] == currentEnd + 1) {
                    currentMax++;
                    currentEnd++;
                }
                else if (array[i] == currentEnd) {
                    // do nothing
                }
                else // restart
                {
                    if (currentMax > maxRange){
                        maxRange = currentMax;
                        startRange = currentStart;
                        endRange = currentEnd;
                    }

                    currentStart = array[i];
                    currentEnd = array[i];
                    currentMax = 1;
                }
            }
        }
        return new int[] {startRange, endRange};
    }
}

