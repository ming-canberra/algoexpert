package com.ming.canberra.hard;

public class FindLoop {
    public static void main(String[] args) {
        FindLoop.findLoop(null);
    }

    public static LinkedList findLoop(LinkedList head) {
        LinkedList nodeSingleSpeed = head;
        LinkedList nodeDoubleSpeed = head;
        while(true){
            nodeSingleSpeed = nodeSingleSpeed.next;
            nodeDoubleSpeed = nodeDoubleSpeed.next.next;
            if (nodeSingleSpeed == nodeDoubleSpeed){
                break;
            }
        }
        LinkedList nodeThird = head;
        if (nodeThird == nodeSingleSpeed){
            return nodeThird;
        }
        while(true){
            nodeSingleSpeed = nodeSingleSpeed.next;
            nodeThird = nodeThird.next;
            if (nodeSingleSpeed == nodeThird){
                break;
            }
        }
        return nodeThird;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

