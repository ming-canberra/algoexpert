package com.ming.canberra.medium;

public class BinaryTreeDiameter {
    public static void main(String[] args) {
        int aa[] = new int[]{2, 1, 1};
        BinaryTreeDiameter arrayOfProducts = new BinaryTreeDiameter();
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

    private int result = 0;
    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        getDepth(tree);
        return result;
    }

    private int getDepth(BinaryTree tree){
        if (tree == null){
            return 0;
        }

        int left;
        if (tree.left == null){
            left = 0;
        }
        else{
            left = 1 + getDepth(tree.left);
        }

        int right;
        if (tree.right == null){
            right = 0;
        }
        else{
            right = 1 + getDepth(tree.right);
        }


        result = Math.max(result, left + right);
        return Math.max(left, right);
    }

}

