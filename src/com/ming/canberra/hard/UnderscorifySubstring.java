package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.List;

public class UnderscorifySubstring {
    public static void main(String[] args) {
        String s = UnderscorifySubstring.underscorifySubstring("testthis is a testtest to see if testestest it works", "test");
        System.out.println(s);
    }

    private static String UNDERSCORE = "_";
    public static String underscorifySubstring(String str, String substring) {
        //put all occurrence in a 2d array
        List<int[]> subStringPositions = new ArrayList<int[]>();
        int startingIndex = 0;
        while (startingIndex < str.length()){
            int currentStartingIndex = str.indexOf(substring, startingIndex);
            if (currentStartingIndex == -1){
                break;
            }
            subStringPositions.add(new int[]{currentStartingIndex, currentStartingIndex + substring.length()});
            startingIndex = currentStartingIndex + 1;
        }

        if (subStringPositions.size() == 0){
            return str;
        }

        //combine the overlapping or side by side ones into a new 2d array
        List<int[]> positionList = new ArrayList<int[]>();

        Integer lastEndingIndex = null;
        Integer lastStartingIndex = null;
        for (int i = 0; i < subStringPositions.size(); i++){
            if (lastEndingIndex == null){
                lastStartingIndex = subStringPositions.get(i)[0];
                lastEndingIndex = subStringPositions.get(i)[1];
            }
            else{
                if (subStringPositions.get(i)[0] <= lastEndingIndex){
                    lastEndingIndex = subStringPositions.get(i)[1];
                }
                else{
                    positionList.add(new int[]{lastStartingIndex, lastEndingIndex});
                    lastStartingIndex = subStringPositions.get(i)[0];
                    lastEndingIndex = subStringPositions.get(i)[1];
                }
            }

            if (i == subStringPositions.size() - 1){
                positionList.add(new int[]{lastStartingIndex, subStringPositions.get(i)[1]});
            }
        }

        // build the result by looping through the original str and the second array.
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, positionList.get(0)[0]));
        for (int i = 0; i < positionList.size(); i++){
            sb.append(UNDERSCORE + str.substring(positionList.get(i)[0], positionList.get(i)[1]) + UNDERSCORE );
            if (i != positionList.size() - 1) {
                sb.append(str.substring(positionList.get(i)[1], positionList.get(i + 1)[0]));
            }
        }
        sb.append(str.substring(positionList.get(positionList.size() - 1)[1]));
        return sb.toString();
    }
}

