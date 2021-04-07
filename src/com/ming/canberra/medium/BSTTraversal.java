package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        BSTTraversal arrayOfProducts = new BSTTraversal();

        var root = new BSTTraversal.BST(10);
        root.left = new BSTTraversal.BST(5);
        root.left.left = new BSTTraversal.BST(2);
        root.left.left.left = new BSTTraversal.BST(1);
        root.left.right = new BSTTraversal.BST(5);
        root.right = new BSTTraversal.BST(15);
        root.right.left = new BSTTraversal.BST(13);
        root.right.left.right = new BSTTraversal.BST(14);
        root.right.right = new BSTTraversal.BST(22);
    }

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        return new ArrayList<Integer>();
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        return new ArrayList<Integer>();
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        return new ArrayList<Integer>();
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

