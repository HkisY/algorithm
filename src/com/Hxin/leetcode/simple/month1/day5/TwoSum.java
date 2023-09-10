package com.Hxin.leetcode.simple.month1.day5;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/6/6 21:33
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int leftPoint = 0, rightPoint = nums.length - 1;
        while (leftPoint < rightPoint) {
            if (nums[leftPoint] + nums[rightPoint] < target) {
                leftPoint++;
            } else if (nums[leftPoint] + nums[rightPoint] > target) {
                rightPoint--;
            } else {
                break;
            }
        }
        int[] res = new int[2];
        res[0] = leftPoint;
        res[1] = rightPoint;
        return res;
    }
}
