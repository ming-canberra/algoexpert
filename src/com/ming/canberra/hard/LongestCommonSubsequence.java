package com.ming.canberra.hard;
import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        List <Character> result = LongestCommonSubsequence.longestCommonSubsequence("ZXVVYZW", "XKYKZPW");
        for (Character c : result){
            System.out.println(c);
        }


    }
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        Set<Character> result = new HashSet<Character>();
        List<Character> resultList = new ArrayList<Character>();

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][]dp = new int[chars1.length][chars2.length];
        for (int i = 0; i < chars1.length; i++)
        {
            for (int j = 0; j < chars2.length; j++)
            {
                if (chars1[i] == chars2[j]){
                    if ( i >=j && !result.contains(chars2[j])){
                        resultList.add(chars2[j]);
                        result.add(chars2[j]);
                    }
                    if (i == 0|| j == 0){
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                else{
                    int upCellValue = i == 0 ? 0 : dp[i - 1][j];
                    int leftCellValue = j == 0 ? 0 : dp[i][j - 1];
                    dp[i][j] = Math.max(upCellValue, leftCellValue);
                }
            }
        }
        return resultList;
    }
}

