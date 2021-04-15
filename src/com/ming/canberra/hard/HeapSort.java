package com.ming.canberra.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort {
    public static void main(String[] args) {
            System.out.println(1);
    }
    public static int[] heapSort(int[] array) {
        List<Integer> heap = new ArrayList<Integer>();
        for (int i : array){
            addAndHeapify(i, heap);
        }
        for (int i = array.length - 1; i >= 0; i--){
            array[i] = removeAndHeapify(heap);
        }
        return array;
    }
    /**
     *  add to the end of the tree and bubble it up
     * */
    private static void addAndHeapify(Integer newValue, List<Integer> heap){
        heap.add(newValue);
        int currentIndex = heap.size() - 1;
        while (currentIndex != 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(parentIndex) < heap.get(currentIndex)) {
                swap(heap, parentIndex, currentIndex);
            }
            else{
                return;
            }
            currentIndex = parentIndex;
        }
    }
    /**
     * swap the top and the end, and bubble the new top down
     * */
    private static Integer removeAndHeapify(List<Integer> heap){
        Integer top = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int currentIndex = 0;
        int minChildIndex = currentIndex * 2 + 1;
        while (minChildIndex <= heap.size() - 1){
            // if second child exists, pick the child with bigger value
            if (minChildIndex < heap.size() - 1){
                minChildIndex = heap.get(currentIndex * 2 + 2) > heap.get(minChildIndex)
                        ?currentIndex * 2 + 2: minChildIndex;
            }
            // swap or not swap
            if (heap.get(currentIndex) < heap.get(minChildIndex)){
                swap(heap, currentIndex, minChildIndex);
                currentIndex = minChildIndex;
                minChildIndex = currentIndex * 2 + 1;
            }
            else{
                break;
            }
        }
        return top;
    }
    private static void swap (List<Integer> heap, int indexA, int indexB){
        int temp = heap.get(indexA);
        heap.set(indexA, heap.get(indexB));
        heap.set(indexB, temp);
    }
}

