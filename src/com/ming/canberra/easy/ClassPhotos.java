package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ClassPhotos {
    public static void main(String[] args) {
        ClassPhotos MinimumWaitingTime = new ClassPhotos();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(1);
        a.add(2);
        System.out.println(MinimumWaitingTime.classPhotos(a, null));
    }

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        int sumHi = 0;
        int sumLo = 0;
        int temp = 0;
        for (int n : redShirtHeights){
            sumHi+=n;
        }
        for (int n : blueShirtHeights){
            sumLo+=n;
        }

        ArrayList<Integer> hiHeights;
        ArrayList<Integer> loHeights;

        if (sumHi > sumLo){
            hiHeights = redShirtHeights;
            loHeights = blueShirtHeights;
        }
        else{
            hiHeights = blueShirtHeights;
            loHeights = redShirtHeights;
            temp = sumLo;
            sumLo = sumHi;
            sumHi = temp;
        }
        if (sumHi - sumLo < hiHeights.size()){
            return false;
        }
        else{
            int[] hiArray = new int[redShirtHeights.size()];
            int[] loArray = new int[redShirtHeights.size()];
            for (int i = 0; i < hiArray.length; i++){
                hiArray[i] = hiHeights.get(i);
                loArray[i] = loHeights.get(i);
            }
            Arrays.sort(hiArray);
            Arrays.sort(loArray);

            for (int i = 0;i < hiArray.length; i++){
                if (hiArray[i] <= loArray[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
