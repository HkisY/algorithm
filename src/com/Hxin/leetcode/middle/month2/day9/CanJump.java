package com.Hxin.leetcode.middle.month2.day9;

/**
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/15  14:33
 */
public class CanJump {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        System.out.println(canJumpByGreed(a));

    }

    public static boolean canJumpByGreed(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int coverRange = 0;
        for (int i = 0; i <= coverRange; i ++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= i + nums[i] && j < nums.length; j++) {
                dp[j] = dp[i];
            }
        }
        return dp[dp.length - 1];
    }
}
