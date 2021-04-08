package com.ming.canberra.medium;

import java.util.List;

public class FindKthLargestValueInBST {
    public static void main(String[] args) {
        var root = new FindKthLargestValueInBST.BST(10);
        root.left = new FindKthLargestValueInBST.BST(5);
        root.left.left = new FindKthLargestValueInBST.BST(2);
        root.left.left.left = new FindKthLargestValueInBST.BST(1);
        root.left.right = new FindKthLargestValueInBST.BST(5);
        root.right = new FindKthLargestValueInBST.BST(15);
        root.right.right = new FindKthLargestValueInBST.BST(22);

    }
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        return -1;
    }
}

