package com.ming.canberra.medium;

import java.util.ArrayList;
import java.util.List;

public class MinHeapConstruction2ndImplementation {
    public static void main(String[] args) {
    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();
        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }
        public List<Integer> buildHeap(List<Integer> array) {
            heap = new ArrayList<Integer>();
            for (int i : array){
                this.insert(i);
            }
            return heap;
        }
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int leftChildIndex = currentIdx * 2 + 1;
            int rightChildIndex = currentIdx * 2 + 2;
            if (rightChildIndex <= endIdx){
                // compare all 3
                int minChildIndex = heap.get(leftChildIndex) < heap.get(rightChildIndex)
                        ? leftChildIndex : rightChildIndex;
                if (heap.get(minChildIndex) < heap.get(currentIdx)){
                    swap(heap, minChildIndex, currentIdx);
                    siftDown(minChildIndex, endIdx, heap);
                }
            }
            else if (leftChildIndex <= endIdx){
                // compare me and my left child
                if (heap.get(currentIdx) > heap.get(leftChildIndex)){
                    swap(heap, currentIdx, leftChildIndex);
                    siftDown(leftChildIndex, endIdx, heap);
                }
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIndex = (currentIdx - 1) / 2;
            while (currentIdx > 0 && heap.get(parentIndex) > heap.get(currentIdx))
            {
                swap(heap, currentIdx, parentIndex);
                currentIdx = parentIndex;
                parentIndex = (currentIdx - 1) / 2;
            }
        }

        public int peek() {
            if (heap.size() > 0){
                return heap.get(0);
            }
            return -1;
        }

        public int remove() {
            if (heap.size() > 0){
                int top = heap.get(0);
                heap.set(0, heap.get(heap.size() - 1));
                heap.remove(heap.size() - 1);
                if (heap.size() > 0) {
                    siftDown(0, heap.size() - 1, heap);
                }
                return top;
            }
            return -1;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        private void swap (List<Integer> list, int indexA, int indexB){
            int temp = list.get(indexA);
            list.set(indexA, list.get(indexB));
            list.set(indexB, temp);
        }
    }
}

