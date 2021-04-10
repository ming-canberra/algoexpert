package com.ming.canberra.medium;

import java.util.Stack;

public class ValidStartingCity {
    public static void main(String[] args) {
    }

    public int validStartingCity(int[] distances, int[] fuel, int mpg) {
        for (int i = 0; i < fuel.length; i++)
        {
            fuel[i] = fuel[i] * mpg;
        }
        int outerIndex = 0;
        while (outerIndex < fuel.length){
            int innerIndex = outerIndex - 1;
            int disToGo = 0;
            int disLeft = 0;
            int numCitiesTraveled = 0;
            while (disLeft >= disToGo){
                if (numCitiesTraveled == fuel.length){
                    return outerIndex;
                }

                if (innerIndex == fuel.length - 1){
                    innerIndex = 0;
                }
                else{
                    innerIndex++;
                }
                disLeft = disLeft - disToGo + fuel[innerIndex];
                disToGo = distances[innerIndex];
                numCitiesTraveled++;
            }
            outerIndex = innerIndex + 1;

            if (outerIndex == fuel.length - 1){
                return outerIndex;
            }
        }

        return -1;
    }
}

