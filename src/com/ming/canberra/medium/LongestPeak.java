package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.List;

public class LongestPeak {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println (LongestPeak.longestPeak(aa));
    }

    public static int longestPeak(int[] array) {
        // Write your code here.
        if (array.length < 3){
            return 0;
        }
        else{
            int result = 0;
            String trend = "";
            int currentStartingIndex = 0;
            if (array[0] == array[1]){
                trend = "FLAT";
            }
            else if (array[0] < array[1]){
                trend = "UP";
            }
            else{
                trend = "FLAT_DOWN";
            }

            for (int i = 2; i < array.length; i++){
                if (array[i] == array[i-1]){
                    if ("DOWN".equals(trend)){
                        // calculate result
                        result = Math.max(result, i - currentStartingIndex);
                    }
                    // start over
                    trend = "FLAT";
                    currentStartingIndex = i;
                }
                // current is going up
                else if (array[i - 1] < array[i]){
                    if ("FLAT".equals(trend)|| "FLAT_DOWN".equals(trend)){
                        // start over
                        trend = "UP";
                        currentStartingIndex = i - 1;
                    }
                    else if ("DOWN".equals(trend)){
                        // calculate result
                        result = Math.max(result, i - currentStartingIndex);
                        // start over
                        trend = "UP";
                        currentStartingIndex = i - 1;
                    }
                }
                // current is going down
                else{
                    if (("UP".equals(trend) || "DOWN".equals(trend) ) && i == array.length - 1){
                        // calculate result
                        result = Math.max(result, i - currentStartingIndex + 1);
                    }
                    else{
                        if ("FLAT".equals(trend)){
                            trend = "FLAT_DOWN";
                            currentStartingIndex = i;
                        }
                        else if ("UP".equals(trend)){
                            trend = "DOWN";
                        }
                    }
                }
            }
            return result;
        }
    }
}

