package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
    public static void main(String[] args) {
        int[] res = BubbleSort.bubbleSort(null);
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = array.length - 1; i>=1; i--){
            for (int j = 1; j <= i; j++){
                int l = array[j - 1];
                int r = array[j];
                if (r < l){
                    // swap
                    array[j] = l;
                    array[j - 1] = r;
                }
            }
        }
        return array;
    }
}
