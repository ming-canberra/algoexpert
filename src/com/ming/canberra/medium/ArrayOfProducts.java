package com.ming.canberra.medium;

import java.util.Arrays;

public class ArrayOfProducts {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        ArrayOfProducts arrayOfProducts = new ArrayOfProducts();
        System.out.println (arrayOfProducts.arrayOfProducts(aa));
    }

    public int[] arrayOfProducts(int[] array) {
        if (array==null || array.length == 1){
            return new int[1];
        }

        int[] result = new int[array.length];

        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        leftProducts[0] = array[0];
        for (int i = 1;i < array.length -1; i++){
            leftProducts[i] = leftProducts[i-1] * array[i];
        }

        rightProducts[array.length - 1] = array[array.length - 1];
        for (int i = array.length - 2;i >= 1; i--){
            rightProducts[i] = rightProducts[i + 1] * array[i];
        }
        for (int i = 0; i < array.length; i++){
            if (i == 0){
                result[i] = rightProducts[i+1];
            }
            else if (i == array.length - 1){
                result[i] = leftProducts[i-1];
            }
            else{
                result[i] = leftProducts[i-1] * rightProducts[i+1];
            }
        }
        return result;
    }
}

