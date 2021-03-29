package com.ming.canberra.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MoveElementToEnd {
    public static void main(String[] args) {
        int aa[] = new int[]{1,2,4,5,6};
        List<Integer> input = new ArrayList<>();
        for (int n : aa){
            input.add(n);
        }
        MoveElementToEnd.moveElementToEnd(input, 3);
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int left = 0;
        int right = array.size() - 1;
        while (left < right){
            while (right >=0 && array.get(right) == toMove){
                right--;
            }
            while (left < array.size() && array.get(left) != toMove){
                left++;
            }
            if (right < 0 || left > array.size() - 1){
                break;
            }
            if (left < right){
            // swap
            int temp = array.get(right);
            array.set(right, array.get(left));
            array.set(left, temp);
            left++;
            right--;
            }
        }

        return array;
    }
}

