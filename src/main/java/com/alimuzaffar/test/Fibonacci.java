package com.alimuzaffar.test;

public class Fibonacci {

    public static void main(String... args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + fibRecursively(i));
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + fibLoop(i));
        }
        System.out.println();
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

    private static int fibLoop(int count) {
        if (count <= 0) {
            return 0;
        } else if (count == 1 || count == 2) {
            return 1;
        } else {
            int fib = 1, fib1 = 1, fib2 = 1;
            for (int i = 3; i <= count; i++) {
                fib = fib1 + fib2;
                fib2 = fib1;
                fib1 = fib;
            }
            return fib;
        }

    }
}