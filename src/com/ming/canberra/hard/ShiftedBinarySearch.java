package com.ming.canberra.hard;

public class ShiftedBinarySearch {
    public static void main(String[] args) {
        int result = ShiftedBinarySearch.shiftedBinarySearch(
                new int[]{45, 61, 71, 72, 73, 0, 1, 21, 33, 37}, 61);
        System.out.println(result);
    }
    public static int shiftedBinarySearch(int[] array, int target) {
        if (array[0] < array[array.length - 1]){
            return binarySearch(array, target, 0, array.length -1);
        }

        return recursive(array, target, 0, array.length - 1);
    }

    private static int recursive(int[] array, int target, int startingIndex, int endingIndex){
        if (target == array[startingIndex]){
            return startingIndex;
        }
        if (target == array[endingIndex]){
            return endingIndex;
        }
        if (startingIndex + 1 < endingIndex){
            int m = startingIndex + (endingIndex - startingIndex) / 2;

            if (array[m] == target){
                return m;
            }
            if (array[m] > array[startingIndex]){
                if (target <= array[m] && target >= array[startingIndex]){
                    return binarySearch(array, target, startingIndex, m);
                }
                else{
                    return recursive(array, target, m + 1, endingIndex);
                }
            }
            else{
                if (target >= array[m] && target <= array[endingIndex]){
                    return binarySearch(array, target, m + 1, endingIndex);
                }
                else{
                    return recursive(array, target, startingIndex, m);
                }
            }
        }
        else{
            return -1;
        }
    }

    private static int binarySearch(int[] array, int target, int startingIndex, int endingIndex){
        while (startingIndex <= endingIndex){
            int m = startingIndex + (endingIndex - startingIndex) / 2;
            if (array[m] == target){
                return m;
            }
            else if (array[m] > target){
                endingIndex = m - 1;
            }
            else{
                startingIndex = m + 1;
            }
        }
        return -1;
    }
}

