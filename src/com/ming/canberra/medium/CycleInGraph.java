package com.ming.canberra.medium;

import java.util.*;

public class CycleInGraph {
    public static void main(String[] args) {
    }
    public boolean cycleInGraph(int[][] edges) {
        for (int i = 0; i < edges.length; i++){
            Stack<Integer> stack = new Stack<Integer>();
            stack.add(i);
            boolean[] visted = new boolean[edges.length];
            while (!stack.isEmpty())
            {
                int popedHead = stack.pop();
                if (visted[popedHead] == false) {
                    for (int value : edges[popedHead]) {
                        if (value == i) {
                            return true;
                        } else {
                            stack.add(value);
                        }
                    }
                    visted[popedHead] = true;
                }
            }
        }
        return false;
    }
}

