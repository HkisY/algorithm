package com.Hxin.algorithm.assignment3;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/23
 */
public class SudokuSolving {
    public static void main(String[] args) {
        int[][] sourceBefore = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        int[][] flagBefore = new int[9][9];

        long startBeforeOpt = System.currentTimeMillis();
        markFlag(sourceBefore, flagBefore);
        dfs(0, sourceBefore, flagBefore);
        long endBeforeOpt = System.currentTimeMillis();
        System.out.println("all the time is " + (endBeforeOpt - startBeforeOpt) + " ms");
    }

    private static void dfs(int count, int[][] source, int[][] flag) {
        if (count == 81) {
            for (int[] i : source) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.print("\n");
            }
            System.out.println("---------------");
            return;
        }
        int lineNum = count / 9;    //line num
        int rowNum = count % 9;    //row num
        if (flag[lineNum][rowNum] == 0) {
            for (int i = 1; i < 10; i++) {
                if (checked(i, source, lineNum, rowNum)) {
                    flag[lineNum][rowNum] = 1;
                    source[lineNum][rowNum] = i;
                    dfs(count + 1, source, flag);
                    flag[lineNum][rowNum] = 0;
                    source[lineNum][rowNum] = 0;
                }
            }
        } else {
            dfs(count + 1, source, flag);
        }
    }

    private static boolean checked(int targetNum, int[][] source, int lineNum, int rowNum) {
        for (int index = 0; index < 9; index++) {
            if (source[lineNum][index] == targetNum) return false;
            if (source[index][rowNum] == targetNum) return false;
            if (source[lineNum / 3 * 3 + index / 3][rowNum / 3 * 3 + index % 3] == targetNum) return false;
        }
        return true;
    }

    private static void markFlag(int[][] source, int[][] flag) {
        int num = 0;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                if (source[i][j] != 0) {
                    flag[i][j] = 2;
                    num++;
                }
            }
        }
        //        return 9 - num;
    }


}
