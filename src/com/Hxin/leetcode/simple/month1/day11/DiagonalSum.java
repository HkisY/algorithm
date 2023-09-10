package com.Hxin.leetcode.simple.month1.day11;

/**
 * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 * <p>
 * 示例  1：
 * <p>
 * 输入：mat = [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * <p>
 * 示例  2：
 * <p>
 * 输入：mat = [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * <p>
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/11 19:08
 */
public class DiagonalSum {
    public static int diagonalSum(int[][] mat) {
        int res = 0;

        int length = mat.length, middle = length / 2;
        for (int i = 0; i < length; i++) {
            res += mat[i][i] + mat[i][length - i - 1];
        }
        if (length % 2 == 0) {
            return res;
        } else {
            return res - mat[middle][middle];
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        System.out.println(diagonalSum(mat));
    }
}
