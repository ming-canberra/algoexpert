package com.ming.canberra.medium;

import java.util.LinkedList;

public class SumOfLinkedLists {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 4, -2, 3, 7, 8, -26};
        SumOfLinkedLists sumOfLinkedLists = new SumOfLinkedLists();
        System.out.println (sumOfLinkedLists.sumOfLinkedLists(new LinkedList(2), new LinkedList(9)));
    }

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList localListOne = linkedListOne;
        LinkedList localListTwo = linkedListTwo;

        LinkedList lastLinkedList = null;
        int carry = 0;
        LinkedList result = null;
        while (localListOne != null || localListTwo != null || carry != 0){

            int listOneInt = localListOne == null ? 0 : localListOne.value;
            int listTwoInt = localListTwo == null ? 0 : localListTwo.value;

            int currentValue = carry + listOneInt + listTwoInt;
            LinkedList newLinkedList;

            if (currentValue > 9){
                newLinkedList = new LinkedList(currentValue % 10);
                carry = 1;
            }
            else{
                newLinkedList = new LinkedList(currentValue);
                carry = 0;
            }

            if (lastLinkedList != null){
                lastLinkedList.next = newLinkedList;
            }
            else{
                result = newLinkedList;
            }

            lastLinkedList = newLinkedList;

            if (localListOne != null){
                localListOne = localListOne.next;
            }
            if (localListTwo != null){
                localListTwo = localListTwo.next;
            }
        }

        return result;
    }
}

