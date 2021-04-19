package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {
    public static void main(String[] args) {
        RadixSort r = new RadixSort();
        ArrayList<Integer> intList = new ArrayList<Integer>();
        for (int i : new int[]{8762, 654, 3008, 345, 87, 65, 234, 12, 2})
        {
            intList.add(i);
        }
        ArrayList<Integer> res = r.radixSort(intList);
    }
    public ArrayList<Integer> radixSort(ArrayList<Integer> array) {
        int maxInt = 0;
        for (int i : array){
            maxInt = Math.max(maxInt, i);
        }
        int timesLooping = 1;
        while (maxInt / 10 != 0){
            timesLooping++;
            maxInt = maxInt / 10;
        }

        int[] oddNumberSortingResult = new int[array.size()];
        int[] evenNumberSortingResult = new int[array.size()];
        int[] digitsArray;

        for (int i = 0; i < array.size(); i++){
            evenNumberSortingResult[i] = array.get(i);
        }
        int[] sourceArray;
        int[] targetArray;
        for (int i = 1; i <= timesLooping; i++ )
        {
            int power10 = (int) Math.pow(10, i - 1);
            digitsArray = new int[10];
            if (i % 2 == 1) {
                sourceArray = evenNumberSortingResult;
                targetArray = oddNumberSortingResult;
            }
            else{
                targetArray = evenNumberSortingResult;
                sourceArray = oddNumberSortingResult;
            }
            for (int j = 0; j < array.size(); j++){
                int remainder = sourceArray[j] / power10 % 10;
                digitsArray[remainder] = digitsArray[remainder] + 1;
            }

            for (int j = 1; j < digitsArray.length; j++){
                digitsArray[j] = digitsArray[j - 1] + digitsArray[j];
            }

            for (int j = 0; j < digitsArray.length; j++){
                digitsArray[j] = digitsArray[j] - 1;
            }

            for (int j = array.size() - 1; j >= 0; j --){
                int remainder = sourceArray[j] / power10 % 10;
                targetArray[digitsArray[remainder]] = sourceArray[j];
                digitsArray[remainder] = digitsArray[remainder] - 1;
            }
        }

        int [] resultArray;
        if (timesLooping % 2 == 1){
            resultArray = oddNumberSortingResult;
        }
        else{
            resultArray = evenNumberSortingResult;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < resultArray.length; i++){
            result.add(resultArray[i]);
        }

        return result;
    }
}
