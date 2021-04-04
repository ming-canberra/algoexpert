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
            for (int i = 0; i < str.length(); i++){
                addToChildren(root, str.substring(i, str.length()));
            }
        }

        private void addToChildren(TrieNode node, String str) {
            if (str.equals(""))
            {
                node.children.put(endSymbol, null);
            }
            else {
                if (node.children.containsKey(str.charAt(0))) {
                    TrieNode valueNode = node.children.get(str.charAt(0));
                    addToChildren(valueNode, str.substring(1, str.length()));
                } else {
                    TrieNode a = new TrieNode();
                    node.children.put(str.charAt(0), a);
                    addToChildren(a, str.substring(1, str.length()));
                }
            }
        }

        public boolean contains(String str) {
            // Write your code here.
            if (str == null)
            {
                return false;
            }
            else if (str.equals("")) {
                return false;
            }
            return contains(root, str);
        }
        private boolean contains(TrieNode node, String str){
            if (str.equals("")) {
                if (node.children.containsKey(endSymbol))
                {
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                TrieNode nextNode = node.children.get(str.charAt(0));
                if (nextNode == null){
                    return false;
                }
                return contains(nextNode, str.substring(1, str.length()));
            }
        }
    }
}

