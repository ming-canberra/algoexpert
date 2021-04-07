package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBST {
    public static void main(String[] args) {
        var root = new MinHeightBST.BST(10);
        root.left = new MinHeightBST.BST(5);
        root.left.left = new MinHeightBST.BST(2);
        root.left.left.left = new MinHeightBST.BST(1);
        root.left.right = new MinHeightBST.BST(5);
        root.right = new MinHeightBST.BST(15);
        root.right.right = new MinHeightBST.BST(22);

    }

    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return null;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}

