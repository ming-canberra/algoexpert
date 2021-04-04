package com.ming.canberra.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SuffixTrieConstruction {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        SuffixTrieConstruction arrayOfProducts = new SuffixTrieConstruction();
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
        }

        public boolean contains(String str) {
            // Write your code here.
            return false;
        }
    }
}

