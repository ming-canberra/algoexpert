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

    public static int nodeDepths(BinaryTree root) {

        return -1;
    }
}
