package com.alimuzaffar.test;

/*
Code to check if we have won a game of connect four
 */
public class ConnectFourWin {
    public static void main(String [] args) {
        // board size doesn't matter as long as both dimensions
        // are at least 4
        int[][] board = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 1, 0, 0, 0, 0, 0},
                {0, 0, 2, 2, 2, 1, 2, 0, 0, 0},
        };

        int result = hasWon(board);
        if (result > 0) {
            System.out.printf("Player %d wins!\n", result);
        } else if (result == 0) {
            System.out.println("No winner yet.");
        } else {
            System.out.println("Game draw.");
        }
    }

    private static int hasWon(int[][] board) {
        // These can be created programmatically but are left hard coded
        // for documentation purposes.
        // when row and column both contain 0 at an index, it means a new check
        // is starting from that index.
        int [] row = new int[] {0,  0,  0,  0, 0, 0, 0, 0, 0, -1, -2, -3, 0, 1, 2, 3, 0, -1, -2, -3, 0, 1, 2, 3, 0,  1,  2,  3, 0, -1, -2, -3};
        int [] col = new int[] {0, -1, -2, -3, 0, 1, 2, 3, 0,  0,  0,  0, 0, 0, 0, 0, 0, -1, -2, -3, 0, 1, 2, 3, 0, -1, -2, -3, 0,  1,  2,  3};

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
                                // Game won by player represented by curVal
                                return curVal;
                            }
                        }
                    }
                }
            }

        }

        if (empty == 0) {
            // Draw
            return -1;
        } else {
            // Still empty cells, no winner yet
            return 0;
        }
    }
}
