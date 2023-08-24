package com.Hxin.leetcode.middle.month2.day1;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * <p>
 * grid = [[1,0],[0,1]]
 * <p>
 * 输出：
 * <p>
 * 0
 * <p>
 * 解释：没有一台服务器能与其他服务器进行通信。
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * <p>
 * grid = [[1,0],[1,1]]
 * <p>
 * 输出：3
 * <p>
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * <p>
 * 示例 3：
 * <p>
 * 输入：
 * <p>
 * grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * <p>
 * 输出：
 * <p>
 * 4
 * <p>
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/8/24  20:14
 */
public class CountServers {
    public static void main(String[] args) {
       int[][] grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(grid));
    }

    public static int countServers(int[][] grid) {
        int res = 0;
        int[] colTag = new int[grid[0].length];
        int[] rowTag = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] ==1){
                    colTag[j]++;
                    rowTag[i]++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] ==1){
                    if (colTag[j]!=1){
                        res++;
                    }else if (rowTag[i]!=1){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
