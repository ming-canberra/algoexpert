package com.ming.canberra.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinMaxStackConstruction {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        MinMaxStackConstruction StaircaseTraversal = new MinMaxStackConstruction();
    }
    // Feel free to add new properties and methods to the class.
    static class MinMaxStack {
        private Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();

        public int peek() {
            int mapSize = map.size();
            if (mapSize > 0){
                return map.get(mapSize)[0];
            }
            return -1;
        }

        public int pop() {
            int mapSize = map.size();
            int result = map.get(mapSize)[0];
            map.remove(mapSize);
            return result;
        }
        public void push(Integer number) {
            int mapSize = map.size();
            int currentMin;
            int currentMax;
            if (mapSize == 0){
                currentMin = Integer.MAX_VALUE;
                currentMax = Integer.MIN_VALUE;
            }
            else{
                currentMin = map.get(mapSize)[1];
                currentMax = map.get(mapSize)[2];
            }
            currentMin = Math.min(currentMin, number);
            currentMax = Math.max(currentMax, number);
            map.put(mapSize + 1, new Integer[]{number, currentMin, currentMax});
        }
        public int getMin() {
            return map.get(map.size())[1];
        }
        public int getMax() {
            return map.get(map.size())[2];
        }
    }
}

