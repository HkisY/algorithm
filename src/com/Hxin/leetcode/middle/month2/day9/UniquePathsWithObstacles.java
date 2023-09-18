package com.Hxin.leetcode.middle.month2.day9;

/**
 * leetcode 63
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/15  15:01
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
//        int[][] obstacleGrid =
//                {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] obstacleGrid =
                {{1, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
            }
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (flag){
                dp[0][i] = 0;
                continue;
            }
            if (obstacleGrid[0][i] == 1){
                dp[0][i] = 0;
                flag = true;
            }
        }
        flag = false;
        for (int i = 0; i < m; i++) {
            if (flag){
                dp[i][0] = 0;
                continue;
            }
            if (obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                flag = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
