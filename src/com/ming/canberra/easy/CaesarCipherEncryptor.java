package com.ming.canberra.easy;

public class CaesarCipherEncryptor {
    public static void main(String[] args) {

        String res = CaesarCipherEncryptor.caesarCypherEncryptor("abcz", 2601);
        System.out.println(res);
    }

    public static String caesarCypherEncryptor(String str, int key) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++){
            int temp = (chars[i] + key - 'a') % 26;
            chars[i] = (char)('a' + temp);
        }
        return new String(chars);
    }
}
