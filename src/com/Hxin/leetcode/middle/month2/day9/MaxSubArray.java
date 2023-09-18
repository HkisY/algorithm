package com.Hxin.leetcode.middle.month2.day9;

/**
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/15  14:15
 */
public class MaxSubArray {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
