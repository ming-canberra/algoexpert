package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SunsetViews {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        SunsetViews arrayOfProducts = new SunsetViews();
        System.out.println (arrayOfProducts.sunsetViews(aa, ""));
    }

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if ("WEST".equals(direction)){
            int currentHeight = 0;
            for (int i = 0; i < buildings.length; i++){
                if (i == 0){
                    result.add(0);
                    currentHeight = buildings[0];
                }
                else {
                    if (buildings[i] > currentHeight){
                        currentHeight = buildings[i];
                        result.add(i);
                    }
                }
            }
        }
        else{
            int currentHeight = 0;
            for (int i = buildings.length - 1; i >= 0; i--){
                if (i == buildings.length - 1){
                    result.add(i);
                    currentHeight = buildings[i];
                }
                else {
                    if (buildings[i] > currentHeight){
                        currentHeight = buildings[i];
                        result.add(i);
                    }
                }
            }

            Collections.reverse(result);

        }
        return result;
    }
}

