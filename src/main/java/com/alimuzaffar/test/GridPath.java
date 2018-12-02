package com.alimuzaffar.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GridPath {

    public static void main(String[] args) {
        // 0 is empty
        // 1 is blocked
        // 2 is the end goal
        // You start at 0,0
        // you can only move horizontally or vertically
        // find the number of steps to 2
        int[][] map = new int[][]{
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0},
        };

        // Answer: Use BFS to find the number of steps.

        // These represent the possible move positions
        // Order top, bottom, left, right
        int[] rm = new int[]{1, -1, 0, 0};
        int[] cm = new int[]{0, 0, -1, 1};

        // column, row
        final int ROW = 0;
        final int COL = 1;
        int[] current = new int[]{0, 0};
        LinkedList<int[]> queue = new LinkedList<>();
        LinkedList<String> found = new LinkedList<>();
        queue.push(current);
        found.push(Arrays.toString(current));
        // There are only 4 possible moves from each position
        while (!queue.isEmpty()) {
            int[] pos = queue.pop();
            System.out.println("Size is " + queue.size());
            int posRow = pos[ROW];
            int posCol = pos[COL];
            if (map[posRow][posCol] == 2) {
                System.out.println("Steps are " + queue.size());
                break; // found
            }
            // else add all the available positions to the queue
            for (int i = 0; i < 4; i++) {
                int r = posRow + rm[i];
                int c = posCol + cm[i];

                if (r < 0 || r >= map.length) continue;
                if (c < 0 || c >= map.length) continue;
//                if (map[r][c] == 2) {
//                    System.out.println("Steps are " + queue.size());
//                    queue.clear();
//                    break;
//                }
                if (map[r][c] != 1) { // 1 being the blocker
                    int [] add = new int[]{r, c};
                    String addStr = Arrays.toString(add);
                    if (!found.contains(addStr)) {

                        System.out.println(r + "," + c);
                        found.push(addStr);
                        queue.push(add);
                    }
                }
            }
        }


    }
}
