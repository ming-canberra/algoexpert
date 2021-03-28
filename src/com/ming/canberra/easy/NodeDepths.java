package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.List;

public class NodeDepths {
    public static void main(String[] args) {
        NodeDepths sortedSquaredArray = new NodeDepths();
        Integer res = NodeDepths.nodeDepths(null);

        System.out.println(res);

    }
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private static int sum = 0;

    public static int nodeDepths(BinaryTree root) {
        sum = 0;
        if (root == null){
            return 0;
        }
        recursiveFun(root, 0);
        return sum;
    }

    private static void recursiveFun(BinaryTree root, int depth){
        if (root== null){
            return;
        }
        sum+=depth;
        if (root.left == null && root.right == null){
            return;
        }
        depth+=1;
        recursiveFun(root.left, depth);
        recursiveFun(root.right, depth);
    }
}
