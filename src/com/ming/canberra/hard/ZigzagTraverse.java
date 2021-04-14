package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagTraverse {
    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3,4, 5)));
        //test.add(new ArrayList<Integer>(Arrays.asList(2, 5, 9, 11)));
        //test.add(new ArrayList<Integer>(Arrays.asList(6, 8, 12, 15)));
        //test.add(new ArrayList<Integer>(Arrays.asList(7, 13, 14, 16)));

        List<Integer>result = ZigzagTraverse.zigzagTraverse(test);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        List<Integer> result = new ArrayList<Integer>();

        int totalRow = array.size();
        int totalCol = array.get(0).size();

        int currentRow = 0;
        int currentCol = 0;
        result.add(array.get(0).get(0));
        while (!(currentRow == totalRow - 1 && currentCol == totalCol -1)){
            boolean goingDownOrRight = whereToNext(currentRow, currentCol, totalRow, totalCol);
            if (goingDownOrRight){
                currentRow+=1;
            }
            else{
                currentCol+=1;
            }
            result.add(array.get(currentRow).get(currentCol));
            // check ending condition
            if (currentRow == totalRow - 1 && currentCol == totalCol -1){
                break;
            }
            // go diagonally
            if (currentRow == totalRow - 1 || currentCol == 0 ){
                //go right top
                while (inBoundary(currentRow, currentCol, totalRow, totalCol)){
                    currentRow--;
                    currentCol++;
                    if (inBoundary(currentRow, currentCol, totalRow, totalCol)){
                        result.add(array.get(currentRow).get(currentCol));
                    }
                }
                currentRow++;
                currentCol--;
            }
            else{
                //go left bottom
                while (inBoundary(currentRow, currentCol, totalRow, totalCol)){
                    currentRow++;
                    currentCol--;
                    if (inBoundary(currentRow, currentCol, totalRow, totalCol)){
                        result.add(array.get(currentRow).get(currentCol));
                    }
                }
                currentRow--;
                currentCol++;
            }
        }

        return result;
    }

    private static boolean inBoundary(int currentRow, int currentCol, int totalRow, int totalCol){
        return currentRow >=0 && currentRow < totalRow && currentCol >= 0 && currentCol < totalCol;
    }

    /**
     * true means down, false means going right
     * */
    private static boolean whereToNext(int currentRow, int currentCol, int totalRow, int totalCol){
        // origin
        if (currentRow == 0 && currentCol == 0){
            if (currentRow + 1 >= totalRow){
                return false;
            }
            return true;
        }
        //top right
        else if (currentRow == 0 && currentCol == totalCol - 1){
            return true;
        }
        //bottom left
        else if (currentRow == totalRow - 1 && currentCol == 0){
            return false;
        }
        // top and bottom row
        else if (currentRow == 0 || currentRow == totalRow - 1){
            return false;
        }
        // left and right column
        else{
            return true;
        }
    }
}

