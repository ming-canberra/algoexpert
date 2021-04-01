package com.ming.canberra.medium;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int aa[] = new int[]{3, 4, -6, 7, 8};
        System.out.println (KadanesAlgorithm.kadanesAlgorithm(aa));
    }

    public static int kadanesAlgorithm2(int[] array) {
        int[] dpTotal = new int[array.length];
        int[] dpUsingCurrent = new int[array.length];

        dpTotal[0] = array[0];
        dpUsingCurrent[0] = array[0];

        for (int i = 1; i < array.length; i++){
            int notUsingCurrent = dpTotal[i - 1];
            int usingCurrent = Math.max(array[i], array[i] + dpUsingCurrent[i - 1]);
            dpUsingCurrent[i] = usingCurrent;
            dpTotal[i] = Math.max(notUsingCurrent, usingCurrent);
        }

        return dpTotal[dpTotal.length - 1];
    }

    public static int kadanesAlgorithm(int[] array) {
        int previousUsingCurrent = array[0];
        int previousTotal = array[0];

        for (int i = 1; i < array.length; i++){
            int notUsingCurrent = previousTotal;
            int usingCurrent = Math.max(array[i], array[i] + previousUsingCurrent);
            previousUsingCurrent = usingCurrent;
            previousTotal = Math.max(notUsingCurrent, usingCurrent);
        }

        return previousTotal;
    }
}

