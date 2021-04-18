package com.ming.canberra.easy;

public class InsertionSort2ndImplementation {
    public static void main(String[] args) {
        int[] res = InsertionSort2ndImplementation.insertionSort(null);
    }

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0; j--){
                if (array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                else{
                    break;
                }
            }
        }
        return array;
    }
}
