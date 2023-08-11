package com.Hxin.leetcode.hard.day11;

/**
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * <p>
 * 示例 1：
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 * <p>
 * 示例 2：
 * 输入：grid = [[7]]
 * 输出：7
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/10 19:23
 */
public class MinFallingPathSum {
    private static int recordMax = Integer.MAX_VALUE;

    public static void main(String[] args) {
//        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] grid = {
                {-73, 61, 43, -48, -36},
                {3, 30, 27, 57, 10},
                {96, -76, 84, 59, -15},
                {5, -49, 76, 31, -7},
                {97, 91, 61, -46, 67}
        };
//        int[][] grid = {{1, 2}, {4, 5}};
//        System.out.println(minFallingPathSumByDFS(grid));
//        System.out.println(minFallingPathSumByDP(grid));
        System.out.println(minFallingPathSumByDPWay(grid));
    }

    /**
     * DFS
     *
     * @param grid grid
     * @return int
     */
    public static int minFallingPathSumByDFS(int[][] grid) {
        int length = grid.length;
        int[][] flag = new int[length][length];
        dfs(0, length, 0, grid, flag);
        return recordMax;
    }

    static void dfs(int count, int length, int res, int[][] grid, int[][] flag) {
        if (count == length) {
            recordMax = Math.min(res, recordMax);
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!checkLegal(flag, count, i)) {
                continue;
            }
            //TODO： 测试用例超时，+剪枝操作
            flag[count][i] = 1;
            res += grid[count][i];
            dfs(count + 1, length, res, grid, flag);
            res -= grid[count][i];
            flag[count][i] = 0;
        }
    }

    private static boolean checkLegal(int[][] flag, int count, int i) {
        if (count != 0) {
            return !(flag[count - 1][i] == 1);
        }
        return true;
    }

    /**
     * DP
     *
     * @param grid grid
     * @return int
     */
    public static int minFallingPathSumByDP(int[][] grid) {
        int length = grid.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        System.arraycopy(grid[0], 0, dp[0], 0, length);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.min(res, dp[length - 1][i]);
        }
        return res;
    }

    public static int minFallingPathSumByDPWay(int[][] grid) {
        int n = grid.length;
        int firstMinSum = 0;
        int secondMinSum = 0;
        int firstMinIndex = -1;
        for (int[] grids : grid) {
            int curFirstMinSum = Integer.MAX_VALUE;
            int curSecondMinSum = Integer.MAX_VALUE;
            int curFirstMinIndex = -1;

            for (int j = 0; j < n; j++) {
                int curSum = (j != firstMinIndex ? firstMinSum : secondMinSum) + grids[j];
                if (curSum < curFirstMinSum) {
                    curSecondMinSum = curFirstMinSum;
                    curFirstMinSum = curSum;
                    curFirstMinIndex = j;
                } else if (curSum < curSecondMinSum) {
                    curSecondMinSum = curSum;
                }
            }
            firstMinSum = curFirstMinSum;
            secondMinSum = curSecondMinSum;
            firstMinIndex = curFirstMinIndex;
        }
        return firstMinSum;
    }
}
