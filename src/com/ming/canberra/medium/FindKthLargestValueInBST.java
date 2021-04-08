package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.Collections;
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
        List<Integer> intFound = new ArrayList<Integer>();
        traverseAndCollectInt(tree, intFound, k);
        Collections.sort(intFound);
        return intFound.get(0);
    }
    private void traverseAndCollectInt(BST tree, List<Integer> list, int k)
    {
        if (list.size() == k){
            return;
        }
        if (tree != null){
            traverseAndCollectInt(tree.right, list, k);
            if (list.size() == k){
                return;
            }
            list.add(tree.value);
            if (list.size() == k){
                return;
            }
            traverseAndCollectInt(tree.left, list, k);
        }
    }
}

