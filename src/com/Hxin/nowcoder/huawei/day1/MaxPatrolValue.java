package com.Hxin.nowcoder.huawei.day1;

/**
 * FZ112
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/20  16:36
 */
public class MaxPatrolValue {
    public static void main(String[] args) {
        System.out.println(maxPatrolValue(new int[]{2, 3, 2}));
    }

    public static int maxPatrolValue(int[] values) {
        // write code here
        int[] dp = new int[values.length + 1];
        dp[0] = 0;
        dp[1] = values[0];
        for (int i = 1; i < values.length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i - 1] + values[i]);
        }

        return dp[values.length];
    }
}
