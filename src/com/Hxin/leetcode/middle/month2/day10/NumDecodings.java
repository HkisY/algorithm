package com.Hxin.leetcode.middle.month2.day10;

/**
 * 91
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/19  15:59
 */
public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(numDecodings("10"));
    }

    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        final char[] chars = s.toCharArray();
        for (int i = 1; i <= len; i++) {
            if (chars[i-1] != '0') {
                dp[i] += dp[i-1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
}
