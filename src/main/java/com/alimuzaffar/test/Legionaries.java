package com.alimuzaffar.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Legionaries {

    public static void main(String[] args) {
        int total = 0;
        for (int i = 1; i <= 2660; i++) {
            String r = RomanNumerals(i);
            total += countChar(r, 'X');
        }
        System.out.println("total is " + total);
    }

    public static int countChar(String str, char charToCount) {
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == charToCount) {
                total++;
            }
        }
        return total;
    }

    public static String RomanNumerals(int num) {
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, Integer> entry : romanNumerals.entrySet()) {
            int matches = num / entry.getValue();
            res.append(repeat(entry.getKey(), matches));
            num = num % entry.getValue();
        }
        return res.toString();
    }

    public static String repeat(String s, int n) {
        if (s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    private static final LinkedHashMap<String, Integer> romanNumerals = new LinkedHashMap<String, Integer>();

    static {
        romanNumerals.put("M", 1000);
        romanNumerals.put("CM", 900);
        romanNumerals.put("D", 500);
        romanNumerals.put("CD", 400);
        romanNumerals.put("C", 100);
        romanNumerals.put("XC", 90);
        romanNumerals.put("L", 50);
        romanNumerals.put("XL", 40);
        romanNumerals.put("X", 10);
        romanNumerals.put("IX", 9);
        romanNumerals.put("V", 5);
        romanNumerals.put("IV", 4);
        romanNumerals.put("I", 1);
    }
}
