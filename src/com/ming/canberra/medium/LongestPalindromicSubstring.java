package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        int aa[] = new int[]{1,2,4,5,6};
        List<Integer> input = new ArrayList<>();
        for (int n : aa){
            input.add(n);
        }
        LongestPalindromicSubstring MergeOverlappingIntervals = new LongestPalindromicSubstring();
        MergeOverlappingIntervals.longestPalindromicSubstring(null);
    }

    public static String longestPalindromicSubstring(String str) {
        char[] chars = str.toCharArray();
        int maxLength = 1;
        String result = str.substring(0, 1);
        for (int i = 0; i < chars.length; i++)
        {
            // odd number
            int j = 0;
            while (i+j < chars.length && i - j >=0){
                if (chars[i+j] != chars[i-j]){
                    break;
                }
                else{
                    int tempLength = 1 + 2 * j;
                    if (tempLength > maxLength){
                        maxLength = tempLength;
                        result = str.substring(i - j, i + j + 1);
                    }
                    j++;
                }
            }
            //even number left central
            j = 0;
            while (i + 1 + j < chars.length && i - j >=0)
            {
                if (chars[i + 1 + j] != chars[i-j]){
                    break;
                }
                else{
                    int tempLength = 2 + 2 * j;
                    if (tempLength > maxLength){
                        maxLength = tempLength;
                        result = str.substring(i - j, i + j + 2);
                    }
                    j++;
                }
            }
        }
        return result;
    }
}

