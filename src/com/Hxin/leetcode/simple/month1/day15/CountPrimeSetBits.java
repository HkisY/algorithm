package com.Hxin.leetcode.simple.month1.day15;

/**
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 * 计算置位位数 就是二进制表示中 1 的个数。
 * <p>
 * 例如， 21 的二进制表示 10101 有 3 个计算置位。
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 6, right = 10
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * 共计 4 个计算置位为质数的数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入：left = 10, right = 15
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 共计 5 个计算置位为质数的数字。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/15 22:22
 */
public class CountPrimeSetBits {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(10, 15));

    }

    private static boolean isPrimeSetBits(int i) {
        int bit = 0;

        while (i > 0) {
            bit += (i >> 1) & 1;
            i = i >> 1;
        }

        return isPrimeNum(bit);
    }

    private static boolean isPrimeNum(int bit) {
        if (bit == 1) {
            return false;
        }
        if (bit == 2 || bit == 3) {
            return true;
        }
        int sqrt = (int) Math.sqrt(bit);
        for (int i = 2; i <= sqrt; i++) {
            if (bit % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i < right + 1; i++) {
            if (isPrimeSetBits(i)) {
                res++;
            }
        }
        return res;
    }
}
