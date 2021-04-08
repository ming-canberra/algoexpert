package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.List;

public class HeightBalancedBinaryTree {
    public static void main(String[] args) {


    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        int lHeight;
        boolean lSubTreeBalanced = true;
        if (tree.left == null){
            lHeight = 0;
        }
        else{
            lSubTreeBalanced = heightBalancedBinaryTree(tree.left);
            lHeight = calculateSubTreeHeight(tree.left);
        }
        int rHeight;
        boolean rSubTreeBalanced = true;
        if (tree.right == null){
            rHeight = 0;
        }
        else{
            rSubTreeBalanced = heightBalancedBinaryTree(tree.right);
            rHeight = calculateSubTreeHeight(tree.right);
        }
        return Math.abs(lHeight - rHeight) <= 1 && lSubTreeBalanced && rSubTreeBalanced;
    }

    private int calculateSubTreeHeight(BinaryTree subTree){
        if (subTree.left == null && subTree.right == null){
            return 1;
        }
        else if (subTree.left == null) {
            return 1 + calculateSubTreeHeight(subTree.right);
        }
        else if (subTree.right == null) {
            return 1 + calculateSubTreeHeight(subTree.left);
        }
        else{
            return 1 + Math.max(calculateSubTreeHeight(subTree.right), calculateSubTreeHeight(subTree.left));
        }
    }
}