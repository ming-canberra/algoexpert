package com.ming.canberra.hard;

import java.util.*;

public class ForNumberSum {
    public static void main(String[] args) {

    }
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        for (int i = 1; i < array.length - 3; i++){
            int[] input = Arrays.copyOfRange(array, i, array.length);
            List<Integer[]> tempResult = threeNumberSum(input, targetSum - array[i - 1]);
            for (Integer[]  tempResultItem : tempResult){
                if (tempResultItem.length == 3){
                    result.add(new Integer[]{array[i - 1], tempResultItem[0], tempResultItem[1], tempResultItem[2]});
                }
            }
        }
        return result;
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++){
            set.add(array[i]);
        }
        for (int i = 0; i < array.length - 2; i++){
            int localTarget = targetSum - array[i];
            set.remove(array[i]);
            for (int j = i + 1; j < array.length - 1; j++){
                set.add(array[j]);
            }
            for (int j = i + 1; j < array.length - 1; j++){
                set.remove(array[j]);
                if (set.contains(localTarget - array[j]) &&  localTarget - array[j] != array[j])
                {
                    result.add(new Integer[]{array[i], array[j], localTarget - array[j]});
                }
            }
        }
        return result;
    }
}
