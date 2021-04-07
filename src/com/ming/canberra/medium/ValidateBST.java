package com.ming.canberra.medium;

import java.util.*;

public class ValidateBST {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        ValidateBST arrayOfProducts = new ValidateBST();

        var root = new ValidateBST.BST(10);
        root.left = new ValidateBST.BST(5);
        root.left.left = new ValidateBST.BST(2);
        root.left.left.left = new ValidateBST.BST(1);
        root.left.right = new ValidateBST.BST(5);
        root.right = new ValidateBST.BST(15);
        root.right.left = new ValidateBST.BST(13);
        root.right.left.right = new ValidateBST.BST(14);
        root.right.right = new ValidateBST.BST(22);
        ValidateBST.validateBst(root);
    }

    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateChildren(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // the root and all her children are between min and max
    private static boolean validateChildren(BST root, int min, int max){
        if (root == null){
            return true;
        }

        if( !(root.value >= min && root.value < max)){
            return false;
        }

        return validateChildren(root.left, min, root.value) && validateChildren(root.right, root.value, max);
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

