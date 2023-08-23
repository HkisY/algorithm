package com.Hxin.leetcode.middle.month1.day6;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * https://leetcode.cn/problems/longest-palindromic-substring/
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/17 21:19
 */
public class LongestPalindrome {
    /**
     * 空间复杂度较小  时间复杂度较高为N^3
     * @param s Stirng
     * @return String
     */
    private static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        final char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        //标记是否回文验证成功
        boolean flag = true;
        //从头开始遍历字符串
        for (int i = 0; i < s.length(); i++) {
            //固定起始字符后，从字符串末尾开始往前遍历
            for (int j = s.length() - 1; j > i; j--) {
                int startLeft = i, endRight = j;
                flag = true;
                //验证是否为回文
                while (startLeft < endRight) {
                    if (chars[startLeft] == chars[endRight]) {
                        startLeft++;
                        endRight--;
                    } else {
                        flag = false;
                        break;
                    }
                }
                //对结果进行赋值
                if (flag) {
                    //保证每次赋值字符串长度均大于上一次赋值的字符串长度
                    if (result.length() < j - i + 1) {
                        result = new StringBuilder();
                        for (int k = i; k <= j; k++) {
                            result.append(chars[k]);
                        }
                    }
                }
            }
        }
        //整个字符串遍历以后均为找到回文 则返回字符串第一个字符
        if (result.length() == 0) {
            return String.valueOf(chars[0]);
        }
        return result.toString();
    }

    private static String longestPalindromeWay(String s){
        return "";
    }

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(longestPalindrome(s));
    }
}
