package com.Hxin.leetcode.simple.month1.day1;

/**
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * <p>
 * 链接：https://leetcode.cn/problems/roman-to-integer
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/2
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') {
                result += 1000;
            } else if (s.charAt(i) == 'D') {
                result += 500;
            } else if (s.charAt(i) == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    result += 400;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    result += 900;
                    i++;
                } else {
                    result += 100;
                }
            } else if (s.charAt(i) == 'L') {
                result += 50;
            } else if (s.charAt(i) == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    result += 40;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    result += 90;
                    i++;
                } else {
                    result += 10;
                }
            } else if (s.charAt(i) == 'V') {
                result += 5;
            } else if (s.charAt(i) == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    result += 4;
                    i++;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    result += 9;
                    i++;
                } else {
                    result += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String x = "MCMXCIV";
        System.out.println(romanToInt(x));
        System.out.println(x.charAt(2));
    }
}
