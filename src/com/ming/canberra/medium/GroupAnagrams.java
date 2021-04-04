package com.ming.canberra.medium;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        GroupAnagrams arrayOfProducts = new GroupAnagrams();
        System.out.println (arrayOfProducts.groupAnagrams(null));
    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.size(); i++)
        {
            char[] chars = words.get(i).toCharArray();
            Arrays.sort(chars);
            String sorted =  new String(chars);
            if (map.containsKey(sorted)){
                List<Integer> temp = map.get(sorted);
                temp.add(i);
                map.put(sorted, temp);
            }
            else{
                List<Integer> newList = new ArrayList<Integer>();
                newList.add(i);
                map.put(sorted, newList);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for (String key : map.keySet()) {
            List<String> temp = new ArrayList<String>();
            for (Integer i : map.get(key)) {
                temp.add(words.get(i));
            }
            result.add(temp);
        }

        return result;
    }


}

