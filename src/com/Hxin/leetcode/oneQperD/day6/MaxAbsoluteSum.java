package com.Hxin.leetcode.oneQperD.day6;

/**
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为
 * abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * abs(x) 定义如下：
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/8 19:13
 */
public class MaxAbsoluteSum {
//    private static int absMax = 0;

    public static void main(String[] args) {
//        int[] nums = {1,-3,2,3,-4};
        int[] nums = {2, -5, 1, -4, 3, -2};
//        maxAbsoluteSumWay(nums);
//        System.out.println(absMax);
//        System.out.println(maxAbsoluteSum(nums));
        System.out.println(maxAbsoluteSumWay(nums));
    }

    public static int maxAbsoluteSum(int[] nums) {
        int length = nums.length;
        int absMax = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int tempSum = 0;
                for (int k = j; k < j + i + 1; k++) {
                    tempSum += nums[k];
                }
                tempSum = tempSum < 0 ? -tempSum : tempSum;
                absMax = Math.max(absMax, tempSum);
            }
        }
        return absMax;
    }

    //    public static int maxAbsoluteSumWay(int[] nums) {
//        int maxPre = 0, minPre = 0, preSum = 0;
//        int res = 0;
//        for (int num : nums) {
//            preSum += num;
//            maxPre = Math.max(preSum, maxPre);
//            minPre = Math.min(preSum, minPre);
//            if (preSum < 0) {
//                res = Math.max(res, -(preSum - maxPre));
//            } else {
//                res = Math.max(res, preSum - minPre);
//            }
//        }
//        return res;
//    }
    public static int maxAbsoluteSumWay(int[] nums) {
        int maxPre = 0, minPre = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            maxPre = Math.max(preSum, maxPre);
            minPre = Math.min(preSum, minPre);
        }
        return Math.max(maxPre - minPre, 0);
    }
}
