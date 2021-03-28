package com.ming.canberra.easy;

public class InsertionSort {
    public static void main(String[] args) {
        int[] res = InsertionSort.insertionSort(null);
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++){
            int current = array[i];
            for (int j = i; j >= 1; j--){
                if (current >= array[j - 1]){
                    array[j] = current;
                    break;
                }
                else {
                    array[j] = array[j - 1];
                }
                if (j == 1){
                    array[0] = current;
                }
            }
        }

        return array;
    }
}
