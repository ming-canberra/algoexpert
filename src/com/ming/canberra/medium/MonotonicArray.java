package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.List;

public class MonotonicArray {
    public static void main(String[] args) {
        MonotonicArray MoveElementToEnd = new MonotonicArray();
        int arrays[] = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        List<Integer> input = new ArrayList<>();
        for (int n : arrays){
            input.add(n);
        }
        MoveElementToEnd.isMonotonic(arrays);
    }

    public static boolean isMonotonic(int[] array) {
        if (array == null || array.length <= 1){
            return true;
        }
        else {
            int length = array.length;
            if (array[0] == array[length - 1]){
                for (int i = 1; i < length; i++){
                    if (array[i - 1] != array[i]){
                        return false;
                    }
                }
            }
            else if (array[0] < array[length - 1]){
                for (int i = 1; i < length; i++){
                    if (array[i - 1] > array[i]){
                        return false;
                    }
                }
            }
            else if (array[0] > array[length - 1]){
                for (int i = 1; i < length; i++){
                    if (array[i - 1] < array[i]){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

