package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BSTTraversal {
    public static void main(String[] args) {
        var root = new BSTTraversal.BST(10);
        root.left = new BSTTraversal.BST(5);
        root.left.left = new BSTTraversal.BST(2);
        root.left.left.left = new BSTTraversal.BST(1);
        root.left.right = new BSTTraversal.BST(5);
        root.right = new BSTTraversal.BST(15);
        root.right.right = new BSTTraversal.BST(22);

        List<Integer> inOrder = Arrays.asList(new Integer[] {1, 2, 5, 5, 10, 15, 22});
        List<Integer> preOrder = Arrays.asList(new Integer[] {10, 5, 2, 1, 5, 15, 22});
        List<Integer> postOrder = Arrays.asList(new Integer[] {1, 2, 5, 5, 22, 15, 10});
        List<Integer> myResult =BSTTraversal.postOrderTraverse(root, new ArrayList<Integer>());
        for (int i : myResult){
            System.out.println(i);
        }
    }

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree != null){
            inOrderTraverse(tree.left, array);
            array.add(tree.value);
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree != null) {
            array.add(tree.value);
            preOrderTraverse(tree.left, array);
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree != null){
            postOrderTraverse(tree.left, array);
            postOrderTraverse(tree.right, array);
            array.add(tree.value);
        }
        return array;
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

