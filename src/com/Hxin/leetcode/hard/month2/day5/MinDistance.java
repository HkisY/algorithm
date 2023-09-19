package com.Hxin.leetcode.hard.month2.day5;

/**
 * 72
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/15  15:43
 */
public class MinDistance {
    public static void main(String[] args) {

    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][3];
        final char[] charArray = word1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
//            删除
            dp[i][0] = Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
//            插入
//            dp[i][1]
////            修改
//            dp[i][2]
        }
        return 0;
    }
}
