package com.alimuzaffar.test;

/*
Code to check if we have won a game of connect four
 */
public class ConnectFourWin {
    //board size
    private static int[][] board = new int[10][10];
    public static void main(String [] args) {
        board = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 1, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 2, 1, 2, 0, 0, 0},
        };

        hasWon(board);
    }

    private static int hasWon(int[][] board) {
        int [] row = new int[] {0,  0,  0,  0, 0, 0, 0, 0, 0, 0, -1, -2, -3, 0, 1, 2, 3, 0, -1, -2, -3, 0, 1, 2, 3, 0,  1,  2,  3, 0, -1, -2, -3};
        int [] col = new int[] {0, -1, -2, -3, 0, 1, 2, 3, 4, 0,  0,  0,  0, 0, 0, 0, 0, 0, -1, -2, -3, 0, 1, 2, 3, 0, -1, -2, -3, 0,  1,  2,  3};

        int sameCount = 0;
        int previous = 0;
        int empty = 0;
        for (int rowIndex = board.length - 1; rowIndex >= 0; rowIndex--) {
            for (int colIndex = 0; colIndex < board[rowIndex].length; colIndex++) {
                for (int i = 0; i < row.length; i++) {
                    int r = row[i] + rowIndex;
                    int c = col[i] + colIndex;
                    if (r < 0 || r >= board.length) continue;
                    if (c < 0 || c >= board[rowIndex].length) continue;
                    int curVal = board[r][c];
                    if (curVal == 0) {
                        empty++;
                        sameCount = 0;
                        previous = 0;
                        System.out.println("Clear, Index " + i);

                    } else {
                        // If we are checking 0, 0, we need to reset the count
                        // Because this means a new check is starting.
                        // If the value has changed from the previous value
                        // then we reset the count, since we already check for
                        // an empty cell (0), then this can only be player 1 or 2.
                        if ((row[i] == 0 && col[i] == 0) || curVal != previous) {
                            sameCount = 1;
                            previous = curVal;
                        } else {
                            sameCount++;
                            if (sameCount == 4) {
                                System.out.println("Player " + curVal + " Wins");
                                return curVal;
                            }
                        }
                    }
                }
            }

        }

        if (empty == 0) {
            System.out.println("Draw");
            return -1;
        } else {
            System.out.println("No winnter yet");
            return 0;
        }
    }
}
