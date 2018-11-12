package com.alimuzaffar.test;

public class QuickSort {
    public static void quicksort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        if (array.length == 1) {
            return;
        }

        quicksort(array, 0, array.length - 1);
    }


    private static void quicksort(int[] inputArray, int low, int high) {

        int lowIndex = low;
        int highIndex = high;

        // Take middle as pivot element.
        int middle = (low + high) / 2;
        int pivotElement = inputArray[middle];

        while (lowIndex <= highIndex) {

            // Keep scanning lower half till value is less than pivot element
            while (inputArray[lowIndex] < pivotElement) {
                lowIndex++;
            }

            // Keep scanning upper half till value is greater than pivot element
            while (inputArray[highIndex] > pivotElement) {
                highIndex--;
            }

            //swap element if they are out of place
            if (lowIndex <= highIndex) {
                swap(inputArray, lowIndex, highIndex);
                lowIndex++;
                highIndex--;
            }
        }

        // Sort lower half -- low to iHighIndex
        if (highIndex > low) {
            quicksort(inputArray, low, highIndex);
        }

        // Sort upper half -- iLowerIndex to high
        if (lowIndex < high) {
            quicksort(inputArray, lowIndex, high);
        }
    }

    //swap elements
    private static void swap(int[] arr, int iElement1, int iElement2) {
        int temp = arr[iElement1];
        arr[iElement1] = arr[iElement2];
        arr[iElement2] = temp;
    }
}
