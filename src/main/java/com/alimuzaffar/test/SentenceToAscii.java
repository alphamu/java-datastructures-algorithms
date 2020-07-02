package com.alimuzaffar.test;

public class SentenceToAscii {
    private static final String vowels = "aeiouAEIOU";

    public static void main(String[] args) {
        String quote = "Dealing with failure is easy: Work hard to improve. Success is also easy to handle: You’ve solved the wrong problem. Work hard to improve.";
        quote = quote.replaceAll("[^\\p{L}\\p{Nd}]+", "");
        char[] chars = quote.toCharArray();
        int total = 0;
        for (char c : chars) {
            int n = c;
            if (vowels.indexOf(c) > -1) {
                n *= -1;
            }
            total += n;
        }
        System.out.println("Total=" + total);
    }
}
