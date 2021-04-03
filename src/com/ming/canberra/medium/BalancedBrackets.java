package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        int aa[] = new int[]{1,2,4,5,6};
        List<Integer> input = new ArrayList<>();
        for (int n : aa){
            input.add(n);
        }
        BalancedBrackets MergeOverlappingIntervals = new BalancedBrackets();
        BalancedBrackets.balancedBrackets(null);
    }

    public static boolean balancedBrackets(String str) {
        // Write your code here.
        Stack<Character> s = new Stack<Character>();
        for (char c : str.toCharArray()) {
            if (!s.isEmpty()) {
                if (isBracket(c)) {
                    if (balanced(s.peek(), c)) {
                        s.pop();
                    } else {
                        s.push(c);
                    }
                }
            } else {
                if (isBracket(c)) {
                    s.push(c);
                }
            }
        }
        return s.isEmpty();
    }
    private static boolean balanced(Character c1, Character c2){
        if (c1 == '(' && c2 == ')'){
            return true;
        }
        if (c1 == '[' && c2 == ']'){
            return true;
        }
        if (c1 == '{' && c2 == '}'){
            return true;
        }
        return false;
    }

    private static boolean isBracket(Character c){
        if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}')
        {
            return true;
        }
        return false;
    }
}

