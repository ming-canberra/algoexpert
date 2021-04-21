package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LaptopRentals {
    public static void main(String[] args) {
        LaptopRentals LaptopRentals = new LaptopRentals();

        int[][] times = new int[][] {{0, 2}, {1, 4}, {4, 6}, {0, 4}, {7, 8}, {9, 11}, {3, 10}};
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        for (int[] time : times) {
            input.add(new ArrayList(Arrays.asList(time[0], time[1])));
        }
        int result = LaptopRentals.laptopRentals(input);
        System.out.println(result);
    }
    public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
        if (times == null || times.size() == 0){
            return 0;
        }
        Collections.sort(times, (a, b)->a.get(0)-b.get(0));

        MinHeap heap  = new MinHeap();

        heap.insert(times.get(0).get(1));
        int result = 1;
        for (int i = 1; i < times.size(); i++)
        {
            if (times.get(i).get(0) < heap.peek()){
                heap.insert(times.get(i).get(1));
                result++;
            }
            else{
                heap.remove();
                heap.insert(times.get(i).get(1));
            }
        }

        return result;
    }
    class MinHeap{
        private List<Integer> heap = new ArrayList<Integer>();

        private void swap(int a, int b){
            int temp = heap.get(a);
            heap.set(a, heap.get(b));
            heap.set(b, temp);
        }
        public void insert(int i){
            heap.add(i);
            int currentIndex = heap.size() - 1;
            // bubble it up from the end
            int parentIndex = (currentIndex - 1) / 2;
            while (currentIndex > 0 && heap.get(currentIndex) < heap.get(parentIndex)){
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1) / 2;
            }
        }
        public int peek(){
            return heap.get(0);
        }
        public void remove(){
            if (heap.size() > 0){
                swap(0, heap.size() - 1);
                heap.remove(heap.size() - 1);
                if (heap.size() > 0){
                    // bubble the top one down to where it belongs
                    bubbleDown(0);


                }
            }
        }
        private void bubbleDown(int index){
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex =  index * 2 + 2;

            if (heap.size() - 1 >= rightChildIndex){
                // compare 2 children and myself
                int minChildIndex = heap.get(leftChildIndex) < heap.get(rightChildIndex) ?
                        leftChildIndex : rightChildIndex;
                if (heap.get(minChildIndex) < heap.get(index)){
                    swap(minChildIndex, index);
                    bubbleDown(minChildIndex);
                }
            }
            else if (heap.size() - 1 == leftChildIndex){
                // compare left child and myself
                if (heap.get(leftChildIndex) < heap.get(index)){
                    swap(leftChildIndex, index);
                }
            }
        }
    }
}

