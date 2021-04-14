package com.ming.canberra.hard;

public class FindLoop {
    public static void main(String[] args) {
        FindLoop.findLoop(null);
    }

    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.
        return null;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

