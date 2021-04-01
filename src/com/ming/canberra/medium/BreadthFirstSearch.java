package com.ming.canberra.medium;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 4, -2, 3, 7, 8, -26};
    }

    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> firstQueue = new LinkedList<Node>();
            firstQueue.add(this);
            while (!firstQueue.isEmpty()) {
                Queue<Node> secondQueue = new LinkedList<Node>();
                while (!firstQueue.isEmpty()) {
                    Node current = firstQueue.poll();

                    array.add(current.name);
                    for (Node n : current.children) {
                        secondQueue.add(n);
                    }
                }
                if (secondQueue.isEmpty()) {
                    return array;
                } else {
                    firstQueue = secondQueue;
                }
            }
            return array;
        }


        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}

