package com.ming.canberra.easy;

public class SelectionSort {
    public static void main(String[] args) {

        int[] res = SelectionSort.selectionSort(null);
    }

    public static int[] selectionSort(int[] array) {
        // Write your code here.
        for (int i = 1; i < array.length; i++){
            int indexMin = i - 1;
            for (int j = i; j< array.length; j++){
                if (array[j] < array[indexMin]){
                    indexMin = j;
                }
            }
            int temp = array[i -1];
            array[i-1] = array[indexMin];
            array[indexMin] = temp;
        }
        return array;
    }
}
