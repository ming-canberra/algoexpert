package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.List;

public class YoungestCommonAncestor {
    public static void main(String[] args) {
        YoungestCommonAncestor MoveElementToEnd = new YoungestCommonAncestor();
        int arrays[] = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        List<Integer> input = new ArrayList<>();
        for (int n : arrays){
            input.add(n);
        }
    }

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDepth(topAncestor, descendantOne);
        int depthTwo = getDepth(topAncestor, descendantTwo);
        AncestralTree youngerDesc = depthOne - depthTwo > 0? descendantOne : descendantTwo;
        AncestralTree olderDesc = depthOne - depthTwo <= 0? descendantOne : descendantTwo;
        int diff = Math.abs(depthOne - depthTwo);
        while (diff > 0){
            diff--;
            youngerDesc = youngerDesc.ancestor;
        }
        // at this point, both tree are on the same level
        while (youngerDesc != olderDesc){
            youngerDesc = youngerDesc.ancestor;
            olderDesc = olderDesc.ancestor;
        }
        return youngerDesc;
    }
    private static int getDepth(AncestralTree topAncestor, AncestralTree descendant){
        if (descendant == topAncestor){
            return 0;
        }
        return 1 + getDepth(topAncestor, descendant.ancestor);
    }


    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }
}

