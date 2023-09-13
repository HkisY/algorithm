package com.Hxin.leetcode.hard.month2.day2;


import java.util.ArrayList;
import java.util.List;

/**
 * 37
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/13  16:33-17:51
 */
public class SolveSudoku {
    private static int[][] row = new int[9][9];
    private static int[][] col = new int[9][9];
    private static int[][] block = new int[9][9];
    private static List<int[]> spaces = new ArrayList<>();
    private static boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    row[i][board[i][j] - '1']
                            = col[j][board[i][j] - '1']
                            = block[i / 3 * 3 + j / 3][board[i][j] - '1']
                            = 1;
                }
            }
        }
        dfs(0, board);

    }

    private void dfs(int count, char[][] board) {
        if (count == spaces.size()) {
            valid = true;
            return;
        }
        int[] index = spaces.get(count);

        for (int j = 0; j < 9 && !valid; j++) {
            if (row[index[0]][j] == 0
                    && col[index[1]][j] == 0
                    && block[index[0] / 3 * 3 + index[1] / 3][j] == 0) {
                board[index[0]][index[1]] = (char) (j + '1');
                row[index[0]][j] =
                        col[index[1]][j] =
                                block[index[0] / 3 * 3 + index[1] / 3][j] = 1;
                dfs(count + 1, board);
                row[index[0]][j] =
                        col[index[1]][j] =
                                block[index[0] / 3 * 3 + index[1] / 3][j] = 0;
            }
        }

    }

}
