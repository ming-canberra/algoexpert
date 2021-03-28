package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int res = BinarySearch.binarySearch(null, 3);

    }

    public static int binarySearch(int[] array, int target) {
        int lo = 0;
        int hi = array.length - 1;

        while (hi - lo > 1){
            int m = lo + (hi - lo)/2;

            if (array[m] == target){
                return m;
            }
            else if (array[m] > target){
                hi = m - 1;
            }
            else{
                lo = m + 1;
            }
        }

        if (target == array[lo]){
            return lo;
        }
        else if (target == array[hi]){
            return hi;
        }
        else{
            return -1;
        }
    }
}
