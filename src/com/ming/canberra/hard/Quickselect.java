package com.ming.canberra.hard;

public class Quickselect {
    public static void main(String[] args) {
        int res = Quickselect.quickselect(new int[]{8, 5, 2, 9, 7, 6, 3},3);
    }

    public static int quickselect(int[] array, int k) {
        int resultIndex = quickSelect(array, k, 0, array.length - 1);
        return array[resultIndex];
    }
    private static int quickSelect(int[]array, int k, int lo, int hi)
    {
        int index = partition(array, lo, hi);
        if (index == k - 1){
            return index;
        }
        else{
            if (k - 1 < index){
                return quickSelect(array, k, lo, index - 1);
            }
            else{
                return quickSelect(array, k, index + 1, hi);
            }
        }
    }
    private static int partition(int[]array, int lo, int hi)
    {
        int pivot = array[hi];

        int startingIndex = lo - 1;

        for (int i = lo; i < hi; i++){
            if (array[i] < pivot){
                startingIndex++;
                swap(array, i, startingIndex);
            }

        }
        swap(array, startingIndex + 1, hi);

        return startingIndex + 1;
    }

    private static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
