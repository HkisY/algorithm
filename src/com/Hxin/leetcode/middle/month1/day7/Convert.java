package com.Hxin.leetcode.middle.month1.day7;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * <p>
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * 链接：https://leetcode.cn/problems/zigzag-conversion
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/18 22:25-23:45
 */
public class Convert {
    public static String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder[] temp = new StringBuilder[numRows];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new StringBuilder();
        }
        for (int i = 0; i < chars.length; i++) {
            if (i % (2 * numRows - 2) < numRows) {
                temp[i % (2 * numRows - 2)].append(chars[i]);
            } else {
                temp[numRows - i % (2 * numRows - 2) + (numRows - 2)].append(chars[i]);
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder value : temp) {
            result.append(value);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
}
