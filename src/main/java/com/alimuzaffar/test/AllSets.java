package com.alimuzaffar.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSets {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4};
        List<int[]> result = new ArrayList<>();
        findAllSetsRecursively(result, input, 0);
        for (int[] r : result) {
            System.out.print(Arrays.toString(r) + ", ");
        }
        result.clear();
        System.out.println();
        findAllSets(result, input);
        for (int[] r : result) {
            System.out.print(Arrays.toString(r) + ", ");
        }
    }

    private static void findAllSets(List<int[]> result, int[] input) {
        if (result == null) {
            return;
        }

        result.add(new int[]{});

        if (input == null) {
            return;
        }

        List<int[]> copy = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            copy.clear();
            for (int[] item : result) {
                int[] c = copy(item);
                // copy into the last slot in the new array.
                c[item.length] = input[i];
                copy.add(c);
            }
            result.addAll(copy);
        }
    }

    private static void findAllSetsRecursively(List<int[]> result, int[] input, int index) {
        if (result == null) {
            return;
        }
        if (result.isEmpty()) {
            result.add(new int[]{});
        }

        if (input == null || index == input.length) {
            return;
        }

        int listSize = result.size();
        for (int i = 0; i < listSize; i++) {
            int[] o = result.get(i);
            int[] c = copy(o);
            // copy into the last slot in the new array.
            c[o.length] = input[index];
            result.add(c);
        }

        findAllSetsRecursively(result, input, ++index);
    }

    /**
     * @param input
     * @return int array which is a copy of input with a 1 more element.
     */
    static int[] copy(int[] input) {
        return Arrays.copyOf(input, input.length + 1);
    }

}
