package com.ming.canberra.hard;

import java.util.HashMap;

public class LongestSubstringWithoutDuplication {
    public static void main(String[] args) {
        LongestSubstringWithoutDuplication.longestSubstringWithoutDuplication("abcdeabcdefc");

    }
    public static String longestSubstringWithoutDuplication(String str) {
        // time complexity O(n), space complexity O(n)
        char[] charArray = str.toCharArray();
        HashMap<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
        int startingIndexForMap = 0;
        int startingIndexForLongestString = 0;
        int endingIndexForLongestString = 1;

        charIndexMap.put(charArray[0], 0);
        for (int i = 1; i < charArray.length; i++)
        {
            if (!charIndexMap.containsKey(charArray[i])){
                charIndexMap.put(charArray[i], i);
            }
            else{
                //if this is the longest so far
                int currentLength = i - startingIndexForMap;
                if (currentLength > endingIndexForLongestString - startingIndexForLongestString) {
                    startingIndexForLongestString = startingIndexForMap;
                    endingIndexForLongestString = i;
                }
                // reset the map, get ready to locate the next duplicates
                int tmpNextStartingIndex = charIndexMap.get(charArray[i]) + 1;
                for (int j = startingIndexForMap; j < tmpNextStartingIndex; j++) {
                    charIndexMap.remove(charArray[j]);
                }
                charIndexMap.put(charArray[i], i);
                startingIndexForMap = tmpNextStartingIndex;
            }
        }
        // handle what is in charIndexMap at the end
        if (charIndexMap.size() > endingIndexForLongestString - startingIndexForLongestString){
            return str.substring(startingIndexForMap);
        }
        else {
            return str.substring(startingIndexForLongestString, endingIndexForLongestString);
        }
    }
}

