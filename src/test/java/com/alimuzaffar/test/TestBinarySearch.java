package com.alimuzaffar.test;

import org.junit.Test;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class TestBinarySearch {
    @Test
    public void testBinarySearch() {
        for (int i = 0; i < 50; i++) {
            int[] randomArray = generateRandomArray(50);
            int randomIndex = randomInt(0, 50);
            int testNumber = randomArray[randomIndex];
            System.out.println("Test number is " + testNumber);
            Arrays.sort(randomArray);
            for (int aRandomArray : randomArray) {
                System.out.print(aRandomArray + ",");
            }
            System.out.println();

            int result = BinarySearch.search(randomArray, testNumber);
            if (result == -1) {
                System.out.println("FAIL");
                break;
            } else {
                System.out.printf("Found at index %d", result);
            }
        }
    }

    @Test
    public void testQuickSort() {
        int[] randomArray = generateRandomArray(10);
        int[] increasing = {0,1,2,3,4,5,6,7,8,9};
        int[] decreasing = {9,8,7,6,5,4,3,2,1,0};

        printArray(randomArray);
        printArray(increasing);
        printArray(decreasing);

        QuickSort.quicksort(randomArray);
        QuickSort.quicksort(increasing);
        QuickSort.quicksort(decreasing);

        printArray(randomArray);
        printArray(increasing);
        printArray(decreasing);


    }

    private void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private int[] generateRandomArray(int size) {
        int[] random = new int[size];
        for (int i = 0; i < size; i++) {
            random[i] = (int) (Math.random() * 100d);
        }
        return random;
    }

    private static int randomInt(int minimum, int maximum) {
        return minimum + (int) (Math.random() * (maximum - minimum));
    }
}
