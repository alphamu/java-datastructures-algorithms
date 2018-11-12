package com.alimuzaffar.test;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int [] array, int value) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (value < array[middle]) {
                high = middle - 1;
            } else if (value > array[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    private static void printArray(int [] array, int start, int end) {
        System.out.println(Arrays.toString(array));
        System.out.println("Start " + start + ", End " + end);
    }
}
