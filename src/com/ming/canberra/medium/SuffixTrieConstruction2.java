package com.ming.canberra.medium;

import java.util.HashMap;
import java.util.Map;

public class SuffixTrieConstruction2 {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        SuffixTrieConstruction2 arrayOfProducts = new SuffixTrieConstruction2();
    }
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            // Write your code here.
            int length = str.length();
            for (int i = length - 1; i >= 0; i--){
                String suffix = str.substring(i, length);
                char[] suffixChars = suffix.toCharArray();
                TrieNode current = root;
                for (int j = 0; j < suffixChars.length; j++){
                    if (!current.children.containsKey(suffixChars[j])){
                        TrieNode newNode = new TrieNode();
                        if (j == suffixChars.length - 1){
                            newNode.children.put(endSymbol, null);
                        }
                        current.children.put(suffixChars[j], newNode);
                    }
                    current = current.children.get(suffixChars[j]);
                }
            }
        }
        public boolean contains(String str) {
            int length = str.length();
            TrieNode current = root;
            for (int i = 0; i < length; i++)
            {
                TrieNode childTrie = current.children.get(str.charAt(i));
                if (childTrie != null) {
                    if (i == length - 1) {
                        return childTrie.children.containsKey('*');
                    }
                    current = childTrie;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}

