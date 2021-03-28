package com.ming.canberra.easy;

import java.util.Arrays;

public class FindClosestValueInBST {
    public static void main(String[] args) {
        FindClosestValueInBST sortedSquaredArray = new FindClosestValueInBST();
        int res = sortedSquaredArray.findClosestValueInBst(null, 12);

        System.out.println(res);

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst2(BST tree, int target) {
        if (tree.value == target|| (tree.left == null && tree.right == null)){
            return tree.value;
        }
        else {
            int currentValue = tree.value;
            //the real work
            int absDiffCurrent;
            int absDiffChild;
            int childResult;

            absDiffCurrent = Math.abs(currentValue - target);

            if (target < currentValue) {
                if (tree.left == null) {
                    childResult = currentValue;
                } else {
                    childResult = findClosestValueInBst(tree.left, target);
                }
            } else {
                if (tree.right == null) {
                    childResult = currentValue;
                } else {
                    childResult = findClosestValueInBst(tree.right, target);
                }
            }

            absDiffChild = Math.abs(target - childResult);

            if (absDiffCurrent < absDiffChild) {
                return tree.value;
            } else {
                return childResult;
            }
        }
    }

    private static int currentClosest = Integer.MAX_VALUE;

    public static int findClosestValueInBst(BST tree, int target) {
        currentClosest = tree.value;

        recursiveFun(tree, target);

        return currentClosest;
    }

    private static void recursiveFun(BST tree, int target){
        if (tree == null){
            return;
        }
        else if (tree.value == target){
            currentClosest = target;
            return;
        }
        else{
            int currentDiff = Math.abs(target - tree.value);
            if (currentDiff < Math.abs(target - currentClosest)){
                currentClosest = tree.value;
            }
            if (target < tree.value){
                recursiveFun(tree.left, target);
            }
            else{
                recursiveFun(tree.right, target);
            }
        }
    }
}
