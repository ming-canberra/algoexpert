package com.ming.canberra.medium;

import java.util.Arrays;

public class SmalletDifference {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        SmalletDifference arrayOfProducts = new SmalletDifference();
        System.out.println (arrayOfProducts.smallestDifference(null, null));
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int indexOne = 0;
        int indexTwo = 0;
        int minValue = Integer.MAX_VALUE;
        int indexMinOne = 0;
        int indexMinTwo = 0;
        while (indexOne < arrayOne.length && indexTwo < arrayTwo.length){
            int tempMin = Math.abs(arrayOne[indexOne] - arrayTwo[indexTwo]);
            if (tempMin < minValue){
                minValue = tempMin;
                indexMinOne = indexOne;
                indexMinTwo = indexTwo;
            }
            if (arrayOne[indexOne] > arrayTwo[indexTwo]){
                indexTwo++;
            }
            else{
                indexOne++;
            }
        }
        return new int[] {arrayOne[indexMinOne], arrayTwo[indexMinTwo]};
    }
}

