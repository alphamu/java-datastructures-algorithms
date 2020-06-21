package com.alimuzaffar.test;

public class FibAddOdd {

    public static void main(String[] args) {
        int total = 0;
        int index = 0;
        int num;
        do {
            num = fibRecursively(index);
            if (num % 2 == 1) {
                total += num;
            }
            index++;
        } while (num < 10000);
        System.out.println("total = " + total);
    }

    private static int fibRecursively(int count) {
        if (count <= 0) {
            return 0;
        } else if (count == 1) {
            return 1;
        } else {
            return fibRecursively(count - 1) + fibRecursively(count - 2);
        }
    }
}