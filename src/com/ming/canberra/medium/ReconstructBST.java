package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReconstructBST {
    public static void main(String[] args) {
        var root = new ReconstructBST.BST(10);
        root.left = new ReconstructBST.BST(5);
        root.left.left = new ReconstructBST.BST(2);
        root.left.left.left = new ReconstructBST.BST(1);
        root.left.right = new ReconstructBST.BST(5);
        root.right = new ReconstructBST.BST(15);
        root.right.right = new ReconstructBST.BST(22);

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

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.

        return null;
    }
}

