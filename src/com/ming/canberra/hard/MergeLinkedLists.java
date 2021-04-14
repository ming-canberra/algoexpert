package com.ming.canberra.hard;

public class MergeLinkedLists {
    public static void main(String[] args) {
        MergeLinkedLists.mergeLinkedLists(null, null);
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList newHead = new LinkedList(1);
        LinkedList currentNode = newHead;
        while(!(headOne == null && headTwo == null)){
            if (headOne == null || headTwo == null)
            {
                if (headTwo == null) {
                    currentNode.next = headOne;
                    headOne = headOne.next;
                } else {
                    currentNode.next = headTwo;
                    headTwo = headTwo.next;
                }
            }
            else {
                if (headOne.value < headTwo.value) {
                    currentNode.next = headOne;
                    headOne = headOne.next;
                } else {
                    currentNode.next = headTwo;
                    headTwo = headTwo.next;
                }
            }
            currentNode.next.next = null;
            currentNode = currentNode.next;
        }
        return newHead.next;
    }
}

