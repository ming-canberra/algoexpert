package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    public static void main(String[] args) {
        BranchSums sortedSquaredArray = new BranchSums();
        List<Integer> res = BranchSums.branchSums(null);

        System.out.println(res);

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


    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> result = new ArrayList<Integer>();
        recursiveFun(root, result, 0);
        return result;
    }

    private static void recursiveFun(BinaryTree root, List<Integer> result, int parentValue){
        if (root == null){
            return;
        }
        root.value+=parentValue;
        recursiveFun(root.left, result, root.value);
        recursiveFun(root.right, result, root.value);
        if (root.left == null && root.right == null){
            result.add(root.value);
        }
    }

}
