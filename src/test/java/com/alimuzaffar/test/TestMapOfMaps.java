package com.alimuzaffar.test;

import org.junit.Before;

import java.nio.charset.Charset;
import java.util.*;

public class TestMapOfMaps {
    Map<String, Object> val;
    List<String> allGeneratedStrings;
    @Before
    void generateTestData() {
        allGeneratedStrings = new ArrayList<>();
        Map<String, Object> val = populateMap2();
    }

    private void populateMap(Map<String, Object> val) {
        int mapCount = randomInt(10, 20);
        byte[] array = new byte[7]; // length is bounded by 7
        Random random  = new Random();

        for (int i = 0; i< mapCount; i++) {
            random.nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));
            allGeneratedStrings.add(generatedString);
            if (Math.random() < 0.3) {
                HashMap<String, Object> map = new HashMap<>();
                populateMap(map);
                val.put(generatedString, map);
            } else {
                val.put(generatedString, generatedString);
            }
        }
    }

    private Map<String, Object> populateMap2() {
        byte[] array = new byte[7]; // length is bounded by 7
        Random random  = new Random();
        Stack<HashMap<String, Object>> stack = new Stack<>();
        HashMap<String, Object> result = new HashMap<>();
        stack.push(result);
        int depth = 0;
        int maxDepth = 5;

        while (!stack.isEmpty()) {
            depth++;
            if (depth == maxDepth) {
                break;
            }
            HashMap<String, Object> m = stack.pop();
            int mapCount = randomInt(10, 20);
            for (int i = 0; i < mapCount; i++) {
                random.nextBytes(array);
                String generatedString = new String(array, Charset.forName("UTF-8"));
                if (Math.random() < 0.3) {
                    HashMap<String, Object> map = new HashMap<>();
                    stack.push(map);
                    m.put(generatedString, map);
                } else {
                    m.put(generatedString, generatedString);
                }
            }
        }

        return result;
    }

    private static int randomInt(int minimum, int maximum) {
        return minimum + (int) (Math.random() * (maximum - minimum));
    }


}
