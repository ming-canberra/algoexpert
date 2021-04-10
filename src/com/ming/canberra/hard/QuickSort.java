package com.ming.canberra.hard;

public class QuickSort {
    public static void main(String[] args) {
        int[] res = QuickSort.quickSort(new int[]{3,3,4,1,3,4,5});
    }

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }
    private static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int loIndex = low - 1;
        for (int i = low; i <= high - 1; i++){
            if (array[i] < pivot){
                loIndex++;
                swap(array, i, loIndex);
            }
        }
        swap(array, loIndex + 1, high);
        return loIndex + 1;
    }
    private static void quickSort(int[]array, int low, int high)
    {
        if (low < high){
            int index = partition(array, low , high);
            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);
        }
    }
    private static void swap (int[] array, int first, int second)
    {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
