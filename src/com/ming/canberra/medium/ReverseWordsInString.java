package com.ming.canberra.medium;

import java.util.*;

public class ReverseWordsInString {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        ReverseWordsInString arrayOfProducts = new ReverseWordsInString();
        System.out.println (arrayOfProducts.reverseWordsInString("null"));
    }
    public String reverseWordsInString(String string) {
        if (string == null){
            return null;
        }
        Stack<String> stack = new Stack<String>();
        char[] chars = string.toCharArray();
        boolean handlingBlank = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++)
        {
            if (i == 0){
                handlingBlank = chars[0] == ' ';
                sb.append(chars[i]);
            }
            else{
                if (handlingBlank){
                    if (chars[i] == ' '){
                        sb.append(chars[i]);
                    }
                    else{
                        stack.push(sb.toString());
                        sb = new StringBuilder();
                        sb.append(chars[i]);
                        handlingBlank = false;
                    }
                }
                else{
                    if (chars[i] == ' '){
                        stack.push(sb.toString());
                        sb = new StringBuilder();
                        sb.append(chars[i]);
                        handlingBlank = true;
                    }
                    else{
                        sb.append(chars[i]);
                    }
                }
            }
            //handle the last
            if (i == chars.length - 1) {
                stack.push(sb.toString());
            }
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}

