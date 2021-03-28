package com.ming.canberra.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearch {
    public static void main(String[] args) {

    }

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }
        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

        public List<String> depthFirstSearch(List<String> array) {
            if (array == null){
                array = new ArrayList<String>();
            }
            // handle herself
            array.add(name);

            // handle children
            if (children != null || children.size() > 0){
                for (Node child : children){
                    child.depthFirstSearch(array);
                }
            }

            return array;
        }


    }
}
