package com.Hxin.leetcode.middle.month2.day9;

/**
 * leetcode 45
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/15  13:55
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));

    }

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + nums[i]&&j<nums.length; j++) {
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                } else {
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
