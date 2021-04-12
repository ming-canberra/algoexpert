package com.ming.canberra.hard;
import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        List <Character> result = LongestCommonSubsequence.longestCommonSubsequence("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "CCCDDEGDHAGKGLWAJWKJAWGKGWJAKLGGWAFWLFFWAGJWKAGTUV");
        for (Character c : result){
            System.out.println(c);
        }
    }
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        List<Character> resultList = new ArrayList<Character>();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int str1Length = chars1.length;
        int str2Length = chars2.length;
        int[][]dp = new int[str1Length + 1][str2Length + 1];
        for (int i = 1; i <= str1Length; i++)
        {
            for (int j = 1; j <= str2Length; j++)
            {
                if (chars1[i - 1] == chars2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        walkBackToOrigin(dp, resultList, str1);
        Collections.reverse(resultList);
        return resultList;
    }
    private static void walkBackToOrigin(int[][] dp, List<Character> resultList, String str1){
        //reversely walk back from dp[m][n]
        int m = dp.length - 1;
        int n = dp[0].length - 1;
        while (m > 0 && n > 0) {

            if (dp[m - 1][n] == dp[m][n]) {
                m--;
            }
            else if (dp[m][n] == dp[m][n - 1]) {
                n--;
            }
            else{
                resultList.add(str1.charAt(m - 1));
                m--;
                n--;
            }
        }
    }
}

