package com.ming.canberra.hard;

public class ValidateThreeNodes {
    public static void main(String[] args) {
        ValidateThreeNodes validateThreeNodes = new ValidateThreeNodes();
        boolean result = validateThreeNodes.validateThreeNodes(null, null, null);
        System.out.println(result);
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
    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        if (isDescendantOf(nodeOne, nodeTwo)){
            if (isDescendantOf(nodeTwo, nodeThree)){
                return true;
            }
        }
        if (isDescendantOf(nodeThree, nodeTwo)){
            if (isDescendantOf(nodeTwo, nodeOne)){
                return true;
            }
        }
        return false;
    }
    private boolean isDescendantOf(BST potentialDescendant, BST root){
        if (root == null){
            return false;
        }
        if (root.right == potentialDescendant || root.left == potentialDescendant){
            return true;
        }
        else{
            if (potentialDescendant.value < root.value){
                return isDescendantOf(potentialDescendant, root.left);
            }
            else{
                return isDescendantOf(potentialDescendant, root.right);
            }
        }
    }
}

