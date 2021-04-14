package com.ming.canberra.hard;

public class ShiftLinkedList {
    public static void main(String[] args) {
        ShiftLinkedList.shiftLinkedList(null, 2);
    }

    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        if (head.next == null){
            return head;
        }
        int length = 0;
        LinkedList current = head;
        LinkedList tail = head;
        while (current != null){
            length++;
            if (current.next == null){
                tail = current;
                break;
            }
            current = current.next;
        }

        k = k % length;
        if (k == 0){
            return head;
        }
        else{
            if (k >0){
                k = k - length;
            }
            while (k != 0){
                k++;
                tail.next = head;
                tail = tail.next;
                head = head.next;
                tail.next = null;
            }
        }
        return head;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}

