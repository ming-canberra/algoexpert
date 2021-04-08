package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.List;

public class FindSuccessor {
    public static void main(String[] args) {

        FindSuccessor.BinaryTree root = new FindSuccessor.BinaryTree(1);
        root.left = new FindSuccessor.BinaryTree(2);
        root.left.parent = root;
        root.right = new FindSuccessor.BinaryTree(3);
        root.right.parent = root;
        root.left.left = new FindSuccessor.BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.right = new FindSuccessor.BinaryTree(5);
        root.left.right.parent = root.left;
        root.left.left.left = new FindSuccessor.BinaryTree(6);
        root.left.left.left.parent = root.left.left;
        FindSuccessor.BinaryTree node = root.left.right;
        FindSuccessor.BinaryTree expected = root;
        FindSuccessor.BinaryTree output = new FindSuccessor().findSuccessor(root, node);
        System.out.println(output.value);

    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    private int _listSizeWhenTargetFound = -1;
    private BinaryTree _result = null;

    /**
     * this works, but it does not use the parent, and not optimal enough
     */
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.

        List<BinaryTree> list = new ArrayList<BinaryTree>();

        inOrderTraversal(tree, list, node);

        return _result;
    }

    private void inOrderTraversal(BinaryTree currentNode, List<BinaryTree> list, BinaryTree targetNode) {
        if (currentNode != null) {
            inOrderTraversal(currentNode.left, list, targetNode);
            if (_listSizeWhenTargetFound != -1 && list.size() > _listSizeWhenTargetFound) {
                return;
            }
            if (list.size() == _listSizeWhenTargetFound) {
                // this is the successor
                _result = currentNode;
                list.add(currentNode);
                return;
            }
            list.add(currentNode);
            if (currentNode == targetNode) {
                _listSizeWhenTargetFound = list.size();
            }
            inOrderTraversal(currentNode.right, list, targetNode);
        }
    }

    /**
     * // TODO use that parent, to get the successor.
     */
    public BinaryTree findSuccessor2(BinaryTree tree, BinaryTree node) {
        return null;
    }

}