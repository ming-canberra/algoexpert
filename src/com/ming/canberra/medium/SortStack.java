package com.ming.canberra.medium;

import java.util.ArrayList;

public class SortStack {
    public static void main(String[] args) {
        int aa[] = new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        SortStack arrayOfProducts = new SortStack();
    }

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        // Write your code here.
        if (stack == null || stack.size() == 0 || stack.size() == 1)
        {
            return stack;
        }
        else{
            Integer topOne = pop(stack);
            compareAndPop(stack, topOne);


        }
        return stack;
    }

    private Integer compareAndPop(ArrayList<Integer> stack, Integer integerToCompare) {

        if (stack.size() > 0 ) {
            Integer topOne = pop(stack);
            compareAndPop(stack, topOne);
        }
        else{

        }
        return 1;
    }


    private int compareAndAppend(ArrayList<Integer> stack, Integer integerToAppend) {

        return 1;
    }

    private Integer peak(ArrayList<Integer> stack) {
        if (stack.size() == 0) {
            return null;
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    private Integer pop(ArrayList<Integer> stack) {
        Integer result = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return result;
    }
}
