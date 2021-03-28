package com.ming.canberra.easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromLinkedList {
    public static void main(String[] args) {
        RemoveDuplicatesFromLinkedList RemoveDuplicatesFromLinkedList = new RemoveDuplicatesFromLinkedList();
        LinkedList res = RemoveDuplicatesFromLinkedList.removeDuplicatesFromLinkedList(null);


    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

        if (linkedList == null){
            return null;
        }

        int lastValue = linkedList.value;
        LinkedList last = linkedList;
        LinkedList current  = linkedList.next;

        while (current != null)
        {
            if (current.value == lastValue){
                last.next = current.next;
            }
            else{
                // new current
                last = current;
                lastValue = current.value;
            }


            current = current.next;
        }

        return linkedList;
    }
}
