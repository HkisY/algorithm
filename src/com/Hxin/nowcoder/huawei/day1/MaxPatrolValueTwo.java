package com.Hxin.nowcoder.huawei.day1;

/**
 * FZ115
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/20  18:14
 */
public class MaxPatrolValueTwo {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(maxPatrolValue(nums));
    }

    public static int maxPatrolValue(int[] values) {
        // write code here
        int[] dp1 = new int[values.length+1];
        int[] dp2 = new int[values.length+1];
//        chose it
        dp1[0] = 0;
        dp1[1] = values[0];
        dp1[2] = values[0];
//        2~end-1
//        dont chose it
        for (int i = 2; i < values.length-1; i++) {
            dp1[i+1] = Math.max(dp1[i],dp1[i-1]+values[i]);
        }
        dp2[0] = 0;
        dp2[1] = 0;
        dp2[2] = values[1];

//        2-end
        for (int i = 2; i < values.length; i++) {
            dp2[i+1] = Math.max(dp2[i],dp2[i-1]+values[i]);
        }
        return Math.max(dp1[values.length-1],dp2[values.length]);
    }
}
