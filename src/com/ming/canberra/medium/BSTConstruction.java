package com.ming.canberra.medium;

public class BSTConstruction {
    public static void main(String[] args) {
        int aa[] = new int[]{2, 1, 1};
        BSTConstruction arrayOfProducts = new BSTConstruction();
   }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            insertRecursively(this, value);
            return this;
        }
        private void insertRecursively(BST bst, int value) {
            if (value < bst.value){
                if (bst.left == null){
                    BST newOne = new BST(value);
                    bst.left = newOne;
                }
                else{
                    insertRecursively(bst.left, value);
                }
            }
            else{
                if (bst.right == null){
                    BST newOne = new BST(value);
                    bst.right = newOne;
                }
                else{
                    insertRecursively(bst.right, value);
                }
            }
        }
        public boolean contains(int value) {
            // Write your code here.
            return containsRecursively(this, value);
        }
        private boolean containsRecursively(BST bst, int value){
            if (bst == null){
                return false;
            }
            else if (bst.value == value){
                return true;
            }
            else if (value < bst.value){
                return containsRecursively(bst.left, value);
            }
            else{
                return containsRecursively(bst.right, value);
            }
        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            return this;
        }
    }
}

