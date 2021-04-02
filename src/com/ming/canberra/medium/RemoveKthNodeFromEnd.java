package com.ming.canberra.medium;

import java.util.*;

public class RemoveKthNodeFromEnd {
    public static void main(String[] args) {
        RemoveKthNodeFromEnd.removeKthNodeFromEnd(null, 4);
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        LinkedList current = head;
        int totalNum = 0;
        while (current != null){
            totalNum++;
            current = current.next;
        }

        if (k == totalNum){
            head.value = head.next.value;
            head.next = head.next.next;
        }
        else{
            current = head;
            for (int i = 1; i < totalNum - k; i++ ){
                current = current.next;
            }
            current.next = current.next.next;
        }
    }
}

