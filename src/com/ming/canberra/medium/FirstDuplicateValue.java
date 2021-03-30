package com.ming.canberra.medium;

public class FirstDuplicateValue {
    public static void main(String[] args) {
        int aa[] = new int[]{2, 1, 1};
        FirstDuplicateValue arrayOfProducts = new FirstDuplicateValue();
        System.out.println (arrayOfProducts.firstDuplicateValue(aa));
    }

    public int firstDuplicateValue(int[] array) {
        for (int i = 0;i < array.length; i++){
            if (array[Math.abs(array[i]) - 1] > 0){
                array[Math.abs(array[i]) - 1] *= -1;
            }
            else{
                return Math.abs(array[i]);
            }
        }
        return -1;
    }
}

