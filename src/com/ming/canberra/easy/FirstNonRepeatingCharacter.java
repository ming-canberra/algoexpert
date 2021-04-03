package com.ming.canberra.easy;

import java.util.*;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        FirstNonRepeatingCharacter tandemBicycle = new FirstNonRepeatingCharacter();
        int res = tandemBicycle.firstNonRepeatingCharacter("");

    }
    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<Character, Integer> theMap = new HashMap<Character, Integer>();
        Set<Character> theSet = new HashSet<Character>();

        for (char c : string.toCharArray()){
            theMap.put(c, theMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : theMap.keySet()){
            if (theMap.get(c) == 1){
                theSet.add(c);
            }
        }

        for (int i = 0; i < string.toCharArray().length; i++)
        {
            if (theSet.contains(string.toCharArray()[i])){
                return i;
            }
        }

        return -1;
    }
}
