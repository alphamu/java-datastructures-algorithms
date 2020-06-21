package com.alimuzaffar.test;

public class Palindromes {

    public static void main(String args[]) {
        int total = 0;
        for (int i = 0; i < 10000; i++) {
            if (isPal(i)) {
                total += i;
            }
        }
        System.out.println(total);
    }

    public static boolean isPal(int n) {
        int r;
        int sum = 0;
        int temp = n;
        while (n > 0) {
            r = n % 10;  //getting remainder
            sum = (sum * 10) + r;
            n = n / 10;
        }
        return (temp == sum);
    }
}
