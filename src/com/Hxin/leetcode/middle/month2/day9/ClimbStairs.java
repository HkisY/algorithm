package com.Hxin.leetcode.middle.month2.day9;

/**
 * 70
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/15  15:33
 */
public class ClimbStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 2; i < n; i++) {
            dp[i + 1] = dp[i] + dp[i - 1];
        }
        return dp[n];
    }
}
