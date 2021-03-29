package com.ming.canberra.easy;

import java.util.HashMap;

public class GenerateDocument {
    public static void main(String[] args) {
        GenerateDocument generateDocument = new GenerateDocument();
        boolean res = generateDocument.generateDocument("abcz", "sdf");
        System.out.println(res);
    }

    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        HashMap<Character, Integer> charMap = new HashMap<>();
        HashMap<Character, Integer> docMap = new HashMap<>();
        fillMap(charMap, characters);
        fillMap(docMap, document);

        for (Character key : docMap.keySet()){
            if (!charMap.containsKey(key)){
                return false;
            }
            else{
                if (charMap.get(key) < docMap.get(key)){
                    return false;
                }
            }
        }
        return true;
    }

    private void fillMap(HashMap<Character, Integer> theMap, String stringText)
    {
        char[] chars = stringText.toCharArray();
        for (char c : chars){
            theMap.put(c, theMap.getOrDefault(c, 0) + 1);
        }
    }
}
