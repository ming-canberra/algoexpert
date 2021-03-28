package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.Collections;

public class FindThreeLargestNumbers {
    public static void main(String[] args) {
        int[] res = FindThreeLargestNumbers.findThreeLargestNumbers(null);
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : array){
            if (list.size() <3){
                list.add(n);
                if (list.size() == 3){
                    Collections.sort(list);
                }
            }
            else{
                if (n > list.get(0)){
                    list.set(0, n);
                    Collections.sort(list);
                }
            }
        }
        int[] rst = new int[3];
        for (int i = 0; i < 3; i++){
            rst[i] = list.get(i);
        }
        return rst;
    }
}
