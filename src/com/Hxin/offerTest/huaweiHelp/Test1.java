package com.Hxin.offerTest.huaweiHelp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/20 18:58
 */
public class Test1 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0},
                {1, 0, 1, 1}};
        System.out.println(solutionByDFS(matrix));
    }

    private static int solutionByDFS(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                continue;
            }
            int tempN = Integer.MAX_VALUE;
            List<Integer> tempAns = new ArrayList<>();
            int[][] flag = new int[m][n];
            flag[i][0] = 1;
            dfs(0, matrix, flag, tempAns, i, 0);
            for (Integer an : tempAns) {
                tempN = Math.min(tempN, an);
            }
            ans.add(tempN);
        }
        int finalAns = Integer.MAX_VALUE;
        for (Integer an : ans) {
            finalAns = Math.min(finalAns, an);
        }
        return finalAns;
    }

    private static void dfs(int count, int[][] matrix, int[][] flag, List<Integer> ans, int line, int row) {
        if (row == matrix[0].length - 1) {
            ans.add(count);
            return;
        }
        int lineUpBoard = Math.min(line + 1, matrix.length - 1);
        int lineDownBoard = Math.max(line - 1, 0);
        int rowUpBoard = Math.min(row + 1, matrix.length - 1);
        int rowDownBoard = Math.max(row - 1, 0);
        for (int i = lineDownBoard; i <= lineUpBoard; i++) {
            for (int j = rowDownBoard; j <= rowUpBoard; j++) {
                if (i + 1 <= matrix.length - 1 && matrix[i + 1][j] == 1 && flag[i + 1][j] == 0) {
                    flag[i + 1][j] = 1;
                    dfs(count + 1, matrix, flag, ans, i + 1, j);
                    flag[i + 1][j] = 0;
                } else if (j + 1 <= matrix[0].length - 1 && matrix[i][j + 1] == 1 && flag[i][j + 1] == 0) {
                    flag[i][j + 1] = 1;
                    dfs(count + 1, matrix, flag, ans, i, j + 1);
                    flag[i][j + 1] = 0;
                } else if (i - 1 >= 0 && matrix[i - 1][j] == 1 && flag[i - 1][j] == 0) {
                    flag[i - 1][j] = 1;
                    dfs(count + 1, matrix, flag, ans, i - 1, j);
                    flag[i - 1][j] = 0;
                } else if (j - 1 >= 0 && matrix[i][j - 1] == 1 && flag[i][j - 1] == 0) {
                    flag[i][j - 1] = 1;
                    dfs(count + 1, matrix, flag, ans, i, j - 1);
                    flag[i][j - 1] = 0;
                } else {
                    break;
                }
            }
        }
    }

    private int solution(int[][] matrix) {
        int[] dp = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1) {
                dp[i] = 1;
            }
        }
        int lineBoard = matrix.length - 1;
        int rowBoard = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1) {
                dp[i] = 1;
            } else {
                continue;
            }
            int startLine = i, startRow = 0;
            int[][] flag = new int[lineBoard][rowBoard];
            flag[startLine][startRow] = 1;
            while (startLine <= lineBoard || startRow <= rowBoard) {
                if (matrix[startLine][startRow] == 0) {
                    break;
                }
                if (matrix[startLine][startRow] == 1) {
                    if (matrix[startLine + 1][startRow] == 1 && flag[startLine + 1][startRow] == 0) {
                        dp[i]++;
                        startLine++;
                    } else if (matrix[startLine][startRow + 1] == 1 && flag[startLine][startRow + 1] == 0) {
                        dp[i]++;
                        startRow++;
                    } else if (startLine - 1 >= 0 && matrix[startLine - 1][startRow] == 1) {
                        dp[i]++;
                        startLine++;
                    } else if (startRow - 1 >= 0 && matrix[startLine][startRow - 1] == 1 && flag[startLine][startRow - 1] == 0) {
                        dp[i]++;
                        startRow++;
                    } else {
                        break;
                    }
                }
            }
        }

        return dp[matrix.length - 1];
    }

    private static int solutionByDp(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < matrix.length; i++) {

        }
        return 0;
    }


}
