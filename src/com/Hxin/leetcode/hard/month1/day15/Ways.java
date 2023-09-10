package com.Hxin.leetcode.hard.month1.day15;

/**
 * 给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1 次，得到 k 块披萨并送给别人。
 * 切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。
 * 请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：pizza = ["A..","AAA","..."], k = 3
 * <p>
 * 输出：3
 * <p>
 * 解释：上图展示了三种切披萨的方案。注意每一块披萨都至少包含一个苹果。
 * <p>
 * 示例 2：
 * <p>
 * 输入：pizza = ["A..","AA.","..."], k = 3
 * <p>
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：pizza = ["A..","A..","..."], k = 1
 * <p>
 * 输出：1
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/17 21:09
 */
public class Ways {


    public static void main(String[] args) {
        String[] pizza = {"A..", "AAA", "..."};
        int k = 3;

    }

    public static int ways(String[] pizza, int k) {

        int rowNum = pizza.length;
        int colNum = pizza[0].toCharArray().length;
        int[] rowSum = new int[rowNum];
        int[] colSum = new int[colNum];
        return 0;
    }

}
