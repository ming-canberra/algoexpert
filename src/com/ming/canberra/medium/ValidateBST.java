package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
        if (tree == null){
            return true;
        }

        int current = tree.value;
        if (tree.left != null){
            int leftChildValue = tree.left.value;
            if (leftChildValue >= current){
                return false;
            }
        }

        if (tree.right != null){
            int rightChildValue = tree.right.value;
            if (rightChildValue < current){
                return false;
            }
        }

        if (!validateBst(tree.left)){
            return false;
        }

        if (!validateBst(tree.right)){
            return false;
        }

        return true;
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

