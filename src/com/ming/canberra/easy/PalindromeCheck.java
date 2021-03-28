package com.ming.canberra.easy;

public class PalindromeCheck {
    public static void main(String[] args) {
        boolean res = PalindromeCheck.isPalindrome("asdf");
    }

    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        int lo = 0;
        int hi = chars.length - 1;
        while (lo < hi){
            if (chars[lo] != chars[hi]){
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
