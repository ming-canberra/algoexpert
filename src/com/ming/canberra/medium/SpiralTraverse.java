package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static void main(String[] args) {
        int aa[][] = new int[][]{{1,2,3,4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        SpiralTraverse.spiralTraverse(aa);
    }

    public static List<Integer> spiralTraverse(int[][] array) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int m = array.length;
        int n = array[0].length;
        int min = Math.min(m,n);

        boolean hasLastSingleRowOrColumn = min % 2 == 1;

        for (int i = 0; i < min / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                arrayList.add(array[i][j]);
            }
            for (int j = i; j < m - 1 - i; j++) {
                arrayList.add(array[j][n - 1 - i]);
            }
            for (int j = n - 1 - i; j > i; j--) {
                arrayList.add(array[m - 1 - i][j]);
            }
            for (int j = m - 1 - i; j > i; j--) {
                arrayList.add(array[j][i]);
            }
            System.out.println();
        }
        if (hasLastSingleRowOrColumn){
            int middle = min / 2;
            if (m == n){
                arrayList.add(array[middle][middle]);
            }
            else if (m > n){
                for (int j = middle; j <= m - 1 - middle; j++){
                    arrayList.add(array[j][middle]);
                }
            }
            else{
                for (int j = middle; j <= n - 1 - middle; j++){
                    arrayList.add(array[middle][j]);
                }
            }
        }
        return arrayList;
    }
}

