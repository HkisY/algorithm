package com.Hxin.offerTest.dewu;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/12 11:13
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] arrays = new int[length];
        for (int i = 0; i < length; i++) {
            arrays[i] = sc.nextInt();
        }
        sc.close();
        int[] dp = new int[length + 1];
        int[] flags = new int[length + 1];
        //如果在第一天做作业
        dp[1] = arrays[0];
        flags[0] = 1;
        dp[2] = dp[0];
        //第一天做
        for (int i = 3; i <= length; i++) {
            if (flags[i - 1] == 1) {
                dp[i] = dp[i - 1];
                flags[i] = 0;
            } else {
                dp[i] = Math.max(dp[i - 2] + arrays[i - 1], dp[i - 3] + arrays[i - 1]);
                flags[i] = 1;
            }
        }
        int tempRes1 = dp[length];
        //如果第2天做作业
//        int[] dp2 = new int[length + 1];
//        int[] flags2 = new int[length + 1];
//        dp2[2] = arrays[1];
//        dp2[1] = 0;
//        flags2[2] = 1;
//        //第一天做
//        for (int i = 3; i <= length; i++) {
//            if (flags2[i - 1] == 1) {
//                dp2[i] = dp2[i - 1];
//                flags2[i] = 0;
//            } else {
//                dp2[i] = Math.max(dp2[i - 2] + arrays[i - 1], dp2[i - 3] + arrays[i - 1]);
//                flags2[i] = 1;
//            }
//        }
//        int tempRes2 = dp2[length];
//        System.out.println(Math.max(tempRes2,tempRes1));

    }
}
