package com.ming.canberra.medium;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class MinHeapConstruction {
    public static void main(String[] args) {
    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();
        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }
        public List<Integer> buildHeap(List<Integer> array) {
            for (Integer i : array){
                insert(i);
            }
            return heap;
        }
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int minChildIndex = currentIdx * 2 + 1;
            while( minChildIndex <= endIdx )
            {
                if (minChildIndex < endIdx){
                    minChildIndex = heap.get(minChildIndex) < heap.get(currentIdx * 2 + 2)?
                            minChildIndex:currentIdx * 2 + 2;
                }
                if (heap.get(minChildIndex) < heap.get(currentIdx)){
                    swap(heap, minChildIndex, currentIdx);
                    currentIdx = minChildIndex;
                    minChildIndex = currentIdx * 2 + 1;
                }
                else{
                    break;
                }
            }
        }
        public void siftUp(int currentIdx, List<Integer> heap) {
            int index = currentIdx;
            while (index != 0 && heap.get(getParentIndex(index)) > heap.get(index) ){
                swap(heap, index, getParentIndex(index));
                index = getParentIndex(index);
            }
        }
        private int getParentIndex(int index){
            int parentIndex;
            if (index % 2 == 1){
                parentIndex = (index - 1) / 2;
            }
            else{
                parentIndex = (index - 2) / 2;
            }
            return parentIndex;
        }

        public int peek() {
            return heap.get(0);
        }
        public int remove() {
            int top = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return top;
        }
        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }
        private void swap(List<Integer> heap, int indexA, int indexB){
            int temp = heap.get(indexA);
            heap.set(indexA, heap.get(indexB));
            heap.set(indexB, temp);
        }
    }
}

