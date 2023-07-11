package com.Hxin.leetcode.middle.day8;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 输入：x = 123
 * 输出：321
 * 输入：x = 120
 * 输出：21
 * <p>
 * 链接：https://leetcode.cn/problems/reverse-integer
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/19 21:36-22:01
 */
public class Reverse {
    private static int reverse(int x) {
        boolean positiveNum = false;
        String tempString = String.valueOf(x);
        if (tempString.startsWith("-")){
            positiveNum = true;
            tempString = tempString.substring(1);
        }
        StringBuilder sb = new StringBuilder(tempString);
        sb.reverse();
        //这里题目假设无法使用long型
        long res = Long.parseLong(sb.toString());
        if (positiveNum) {
            if (-res < Integer.MIN_VALUE) {
                return 0;
            } else {
                return -(int) res;
            }
        } else {
            if (res > Integer.MAX_VALUE) {
                return 0;
            } else {
                return (int) res;
            }
        }
    }

    private static int reverseWay(int x) {
        int positiveNum = 1;
        String tempString = String.valueOf(x);
        if (tempString.startsWith("-")){
            positiveNum = -1;
            tempString = tempString.substring(1);
        }
        StringBuilder sb = new StringBuilder(tempString);
        sb.reverse();
        try {
            return Integer.parseInt(sb.toString())*positiveNum;
        }catch(Exception e){
            return 0;
        }
    }


    public static void main(String[] args) {
        int a = -2147483648;
        System.out.println(reverseWay(a));

    }
}
