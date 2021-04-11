package com.ming.canberra.hard;

public class QuickSortSecondImplementation {
    public static void main(String[] args) {
        int[] res = QuickSortSecondImplementation.quickSort(new int[]{3,3,4,1,3,4,5});
    }

    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static int partition(int[]array, int loIndex, int hiIndex){
        int pivot = array[hiIndex];
        int startIndex = loIndex - 1;
        for (int i = loIndex; i < hiIndex; i++){
            if (array[i] < pivot){
                startIndex++;
                swap(array, startIndex, i);
            }
        }
        swap(array, startIndex + 1, hiIndex);

        return startIndex + 1;
    }

    private static void quickSort(int[] array, int loIndex, int hiIndex){
        if (loIndex < hiIndex){
            int index = partition(array, loIndex, hiIndex);
            quickSort(array, loIndex, index - 1);
            quickSort(array, index + 1, hiIndex);
        }
    }

    private static void swap (int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
