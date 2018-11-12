package com.alimuzaffar.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("Duplicates")
public class TestMaxHeap {
    @Test
    public void testInsertIntoMaxHeap() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(5);
        maxHeap.insert(4);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(1);
        System.out.println(maxHeap);
        testPoppingHeap(maxHeap);
    }

    @Test
    public void testInsertIntoMaxHeap2() {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(5);
        System.out.println(maxHeap);
        testPoppingHeap(maxHeap);

    }

    private void testPoppingHeap(MaxHeap maxHeap) {
        for (int i = 0; maxHeap.size() > 0; i++) {
            int maxVal = maxHeap.pop();
            assertEquals(5 - i, maxVal);
            System.out.print("Popped max val: " + maxVal + " <- ");
            System.out.println(maxHeap);
        }
    }
}
