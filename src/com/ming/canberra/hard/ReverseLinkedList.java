package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
            System.out.println("");
    }

    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList result = null;
        while (head != null) {
            LinkedList temp = head;
            head = head.next;
            temp.next = result;
            result = temp;
        }
        return result;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

