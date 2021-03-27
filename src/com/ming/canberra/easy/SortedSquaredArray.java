package com.ming.canberra.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortedSquaredArray {
    public static void main(String[] args) {
        SortedSquaredArray sortedSquaredArray = new SortedSquaredArray();
        int[] res = sortedSquaredArray.sortedSquaredArray(null);

        for (int n : res){
            System.out.println(n);
        }
    }

    public int[] sortedSquaredArray(int[] array) {
        for (int i = 0;i < array.length; i++){
            array[i] = Math.abs(array[i]);
        }
        Arrays.sort(array);
        int[] result = new int[array.length];
        for (int i = 0;i < array.length; i++){
            result[i] = array[i] * array[i];
        }
        return result;
    }
}
