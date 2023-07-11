package com.Hxin.leetcode.oneQperD.day1;

/**
 * 给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
 * 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,6,10,12,15]
 * 输出：9
 * 解释：6 和 12 是可以被 3 整除的偶数。(6 + 12) / 2 = 9 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,4,7,10]
 * 输出：0
 * 解释：不存在满足题目要求的整数，所以返回 0 。
 * <p>
 * 链接：https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/29 21:16
 */
public class AverageValue {
    public static int averageValue(int[] nums) {
        int sum = 0, size = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                continue;
            }
            if (num % 3 == 0) {
                sum += num;
                size++;
            }
        }
        if (size == 0) {
            return size;
        }
        return sum / size;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 10, 12, 15};
    }
}
