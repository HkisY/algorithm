package com.Hxin.leetcode.middle.month2.day8;

/**
 * 198
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/14  16:01
 */
public class Rob {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i+1] = Math.max(dp[i-1] + nums[i], dp[i]);
        }
        return dp[nums.length];
    }
}
