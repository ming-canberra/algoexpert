package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RiverSizes {
    public static void main(String[] args) {
        RiverSizes.riverSizes(new int[][]{new int[]{1,2},new int[]{1,43}});
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        int riverIndex = 1;
        HashMap<Integer, List<int[]>> map = new HashMap<Integer, List<int[]>>();
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (i == 0 && j ==0){
                    if (matrix[i][j] == 1){
                        // put new river into map
                        List<int[]> tempList = new ArrayList<int[]>();
                        tempList.add(new int[]{i, j});
                        riverIndex++;
                        map.put(riverIndex, tempList);
                        matrix[i][j] = riverIndex;
                    }
                }
                else{
                    if (matrix[i][j] == 1){
                        if (i == 0){
                            if (matrix[i][j-1] != 0){
                                matrix[i][j] = matrix[i][j-1];
                                map.get(matrix[i][j-1]).add(new int[]{i, j});
                            }
                            else{
                                // put new river into map
                                List<int[]> tempList = new ArrayList<int[]>();
                                tempList.add(new int[]{i, j});
                                riverIndex++;
                                map.put(riverIndex, tempList);
                                matrix[i][j] = riverIndex;
                            }
                        }
                        else if (j == 0){
                            if (matrix[i-1][j] != 0){
                                matrix[i][j] = matrix[i-1][j];
                                map.get(matrix[i-1][j]).add(new int[]{i, j});
                            }
                            else{
                                // put new river into map
                                List<int[]> tempList = new ArrayList<int[]>();
                                tempList.add(new int[]{i, j});
                                riverIndex++;
                                map.put(riverIndex, tempList);
                                matrix[i][j] = riverIndex;
                            }
                        }
                        else if (i != 0 && j != 0){
                            if (matrix[i-1][j] != 0 && matrix[i][j-1] != 0){
                                int a = matrix[i-1][j];
                                int b = matrix[i][j-1];
                                // a != b,always merge b to a
                                if (a != b) {
                                    List<int[]> listA = map.get(a);
                                    List<int[]> listB = map.get(b);
                                    map.remove(b);
                                    for (int[] currentElement : listB){
                                        matrix[currentElement[0]][currentElement[1]] = a;
                                        listA.add(currentElement);
                                    }
                                }
                                map.get(a).add(new int[]{i, j});
                                matrix[i][j] = a;
                            }
                            else if (matrix[i-1][j] != 0 || matrix[i][j-1] != 0){
                                int a = Math.max(matrix[i-1][j], matrix[i][j-1]);
                                map.get(a).add(new int[]{i, j});
                                matrix[i][j] = a;
                            }
                            else{
                                // put new river into map
                                List<int[]> tempList = new ArrayList<int[]>();
                                tempList.add(new int[]{i, j});
                                riverIndex++;
                                map.put(riverIndex, tempList);
                                matrix[i][j] = riverIndex;
                            }
                        }
                    }
                }
            }
        }
        ArrayList<Integer> toReturn = new ArrayList<Integer>();
        for (List<int[]> list : map.values()){
            toReturn.add(list.size());
        }
        return toReturn;
    }
}

