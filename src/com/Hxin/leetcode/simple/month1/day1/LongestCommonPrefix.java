package com.Hxin.leetcode.simple.month1.day1;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/3 21:49
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length == 0){
            return "";
        }
        //取得最短字符串的长度
        int num = Integer.MAX_VALUE;
        for (String str : strs) {
            if (num > str.length()) {
                num = str.length();
            }
        }
        StringBuilder temp = new StringBuilder();
        OUT:
        for (int i = 0; i < num; i++) {
            for (String str : strs) {
                if (temp.length() == 0) {
                    temp.append(str.charAt(i));
                } else if (!temp.toString().equals(String.valueOf(str.charAt(i)))) {
                    temp.delete(0, 1);
                    break OUT;
                }
            }
            result.append(temp);
            temp.delete(0,1);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
        System.out.println(longestCommonPrefixWay(strings));
    }

    public static String longestCommonPrefixWay(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1 )
            return strs[0];
        String s = strs[0];
        for(String str : strs){
            while(!str.startsWith(s)){
                s = s.substring(0,s.length()-1);
            }
        }
        return s;
    }
}
