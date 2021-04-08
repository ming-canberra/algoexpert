package com.ming.canberra.medium;

import java.util.ArrayList;

public class InvertBinaryTree {
    public static void main(String[] args) {
    }
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree != null){
            BinaryTree temp = tree.left;
            tree.left = tree.right;
            tree.right = temp;
            invertBinaryTree(tree.left);
            invertBinaryTree(tree.right);
        }
    }
}

