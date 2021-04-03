package com.ming.canberra.easy;

import java.util.Arrays;

public class TandemBicycle {
    public static void main(String[] args) {
        TandemBicycle tandemBicycle = new TandemBicycle();
        int res = tandemBicycle.tandemBicycle(null, null, true);

    }
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        int[] total = new int[redShirtSpeeds.length + blueShirtSpeeds.length];
        for (int i = 0; i < redShirtSpeeds.length; i++){
            total[i] = redShirtSpeeds[i];
        }
        for (int i = 0; i < blueShirtSpeeds.length; i++){
            total[redShirtSpeeds.length + i] = blueShirtSpeeds[i];
        }
        Arrays.sort(total);
        if (fastest){
            int sumFastestHalf = 0;
            for (int i = redShirtSpeeds.length; i < total.length; i++){
                sumFastestHalf += total[i];
            }
            return sumFastestHalf;
        }
        else{
            int sumSlowHalf = 0;

            Arrays.sort(redShirtSpeeds);
            Arrays.sort(blueShirtSpeeds);

            for (int i = 0; i < redShirtSpeeds.length; i++){
                sumSlowHalf += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }

            return sumSlowHalf;
        }
    }
}
