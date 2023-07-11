package com.Hxin.leetcode.middle.day9;

/**
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为
 * −231 ，大于 2^31− 1 的整数应该被固定为 2^31− 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * 链接：https://leetcode.cn/problems/string-to-integer-atoi
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/21 18:28
 */
public class MyAtoi {
    private static int myAtoi(String s) {
        while (s.startsWith(" ")) {
            s = s.substring(1);
        }
        //标记是否为负数
        boolean flag = false;
        if (s.startsWith("-")) {
            flag = true;
            s = s.substring(1);
        } else if (s.startsWith("+")) {
            s = s.substring(1);
        }
        while (s.startsWith("0")) {
            s = s.substring(1);
        }
        final char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar >= 48 && aChar <= 57) {
                sb.append(aChar);
            } else {
                break;
            }
        }
        if (sb.toString().length() == 0) {
            return 0;
        }

        if (sb.toString().length() > 10) {
            if (flag) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        long value = Long.parseLong(sb.toString());
        if (flag) {
            value = -value;
        }
        if (value > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (value < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) value;
        }
    }

    public static void main(String[] args) {
        String s = "20000000000000000000";
        System.out.println(myAtoi(s));
    }
}
