package com.Hxin.leetcode.middle.day13;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * <p>
 * 链接：https://leetcode.cn/problems/3sum-closest
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/28 16:13
 */
public class ThreeSumClosest {
    //Time out
    private static int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int leftPoint = i + 1;
            int rightPoint = nums.length - 1;
            while (leftPoint < rightPoint) {
                if (rightPoint < nums.length - 1 && nums[rightPoint] == nums[rightPoint + 1]) {
                    rightPoint--;
                    continue;
                }
                if (leftPoint > i + 1 && nums[leftPoint] == nums[leftPoint - 1]) {
                    leftPoint++;
                    continue;
                }
                int sum = nums[rightPoint] + nums[leftPoint] + nums[i];
                int distance = target - sum;
                if (distance > 0) {
                    leftPoint++;
                    if (distance < result) {
                        result = distance;
                        flag = true;
                    }
                }else if (distance < 0) {
                    rightPoint--;
                    if (-distance < result) {
                        result = -distance;
                        flag = false;
                    }
                }else {
                    return target;
                }
            }
        }
        if (flag){
            return target-result;
        }else {
            return target+result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2;
        System.out.println(threeSumClosest(nums, target));
    }
}
