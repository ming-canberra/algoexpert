package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.Arrays;

public class AmbiguousMeasurements {
    public static void main(String[] args) {
        AmbiguousMeasurements ambiguousMeasurements = new AmbiguousMeasurements();
        int[][] cups = new int[][] {{50, 65}, {100, 120}, {20, 40}, {10, 15},
                {400, 500}, {300, 350}, {10, 25}};
        int low = 3000;
        int high = 3300;
        boolean result = ambiguousMeasurements.ambiguousMeasurements(cups, low, high);
        System.out.println("asdfasdf" + result);
    }

    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        Arrays.sort(measuringCups, (a,b)->a[0]-b[0]);
        return canMeasure(measuringCups, low, high);
    }
    private boolean canMeasure(int[][] measuringCups, int low, int high){
        boolean subResults [] = new boolean[measuringCups.length];
        for (int i = 0; i < measuringCups.length; i++){
            int cupLow = measuringCups[i][0];
            int cupHigh = measuringCups[i][1];
            if (cupLow >= low && cupHigh <= high){
                return true;
            }
            else if (cupLow >= low && cupHigh > high){
                break;
            }
            else if (cupLow < low && cupHigh <= high){
                if (low - cupLow <= high-cupHigh) {
                    subResults[i] = canMeasure(measuringCups, low - cupLow, high - cupHigh);
                    if (subResults[i]){
                        return true;
                    }
                }
                else{
                    subResults[i] = false;
                }
            }
            else{
                subResults[i] = false;
            }
        }

        return false;
    }
}

