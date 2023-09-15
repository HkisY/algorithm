package com.Hxin.leetcode.hard.month2.day3;

/**
 * 42
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/14  16:22
 */
public class Trap {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int[] prefixBoard = new int[height.length];
        int[] suffixBoard = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (prefixBoard[i] < height[i]) {
                prefixBoard[i] = height[i];
            }
            if (i >= 1 && prefixBoard[i] < prefixBoard[i - 1]) {
                prefixBoard[i] = prefixBoard[i - 1];
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (suffixBoard[i] < height[i]) {
                suffixBoard[i] = height[i];
            }
            if (i < height.length - 1 && suffixBoard[i] < suffixBoard[i + 1]) {
                suffixBoard[i] = suffixBoard[i + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(prefixBoard[i], suffixBoard[i]) - height[i];
        }
        return ans;
    }

    public static int trapByDP(int[] height){
        int[] dp = new int[height.length];
        dp[0] = 0;
        for (int i = 0; i < height.length; i++) {
            int water = 0;
        }
        return 0;
    }
}
