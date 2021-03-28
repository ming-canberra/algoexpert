package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    public static void main(String[] args) {
        BranchSums sortedSquaredArray = new BranchSums();
        List<Integer> res = BranchSums.branchSums(null);

        System.out.println(res);

    }
    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        return new ArrayList<Integer>();
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


}
