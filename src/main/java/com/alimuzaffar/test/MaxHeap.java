package com.alimuzaffar.test;

import java.util.Arrays;

public class MaxHeap {

    private int [] heap;
    private int count = 0;
    MaxHeap() {
        heap = new int[]{-1, -1, -1, -1, -1, -1, -1};
    }

    void insert(int val) {
        if (count == heap.length) {
            heap = Arrays.copyOf(heap, count * 2);
        }
        int index = count;
        int parentIndex = (int) Math.floor((index - 1) / 2);
        while (index > 0 && val > heap[parentIndex]) {
            heap[index] = heap[parentIndex];
            index = parentIndex;
            parentIndex = (int) Math.floor((index - 1) / 2);
        }

        heap[index] = val;
        count++;
    }

    int pop() {
        int temp = heap[0];
        heap[0] = heap[count - 1];
        heap[count - 1] = -1;
        count--;
        heapify(0);
        return temp;

    }

    private void heapify(int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        int maxValueIndex = index;
        if (leftIndex < count && heap[leftIndex] > heap[maxValueIndex]) {
            maxValueIndex = leftIndex;
        }
        if (rightIndex < count && heap[rightIndex] > heap[maxValueIndex]) {
            maxValueIndex = rightIndex;
        }

        if (index != maxValueIndex) {
            swap(index, maxValueIndex);
            heapify(maxValueIndex);
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public String toString() {
        StringBuffer sb = null;
        for (int i = 0; i < count; i++) {
            if (sb == null) {
                sb = new StringBuffer("[");
            } else {
                sb.append(",");
            }
            sb.append(heap[i]);
        }
        if (sb != null) {
            sb.append("]");
            return sb.toString();
        } else {
            return "null";
        }
    }

    int size() {
        return count;
    }


}
