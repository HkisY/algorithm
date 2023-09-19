package com.Hxin.leetcode.hard.month2.day5;

/**
 * 85
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/18  17:02
 */
public class MaximalRectangle {
    public static void main(String[] args) {

    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (dp[i - 1][j] == dp[i][j - 1] && dp[i - 1][j - 1] != 0 && dp[i][j - 1] != 0 && dp[i - 1][j] != 0) {
                        dp[i][j] = 2 * dp[i - 1][j] - dp[i - 1][j - 1] + 1;
                    } else if (dp[i - 1][j] == 0 || dp[i][j - 1] == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int[] ints : dp) {
            for (int anInt : ints) {
                ans = Math.max(ans, anInt);
            }
        }
        return ans;
    }
}
