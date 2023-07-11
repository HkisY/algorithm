package com.Hxin.leetcode.middle.day5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/14 18:24
 */
public class LengthOfLongestSubstring {
    private static int lengthOfLongestSubstring(String s) {
        char[] characters = s.toCharArray();
        int windowLeft = 0;
        int windowRight = 0;
        Queue<Character> tempChar = new LinkedList<>();
        Queue<Character> repeatChar = new LinkedList<>();
        while (windowRight < characters.length) {
            //标志队列内是否有重复元素
            boolean flag = false;
            //判断队列内部是否有重复元素
            if (!tempChar.isEmpty()) {
                while (!tempChar.isEmpty()) {
                    Character poll = tempChar.poll();
                    if (repeatChar.contains(poll)) {
                        flag = true;
                    }
                    repeatChar.add(poll);
                }
            } else {
                while (!repeatChar.isEmpty()) {
                    Character poll = repeatChar.poll();
                    if (tempChar.contains(poll)) {
                        flag = true;
                    }
                    tempChar.add(poll);
                }
            }
            if (!tempChar.isEmpty()) {
                if (flag || tempChar.contains(characters[windowRight])) {
                    //若在窗口内找到相同的字符则整个窗口右移
                    tempChar.add(characters[windowRight]);
                    windowRight++;
                    windowLeft++;
                    tempChar.poll();
                } else {
                    //在窗口内没找到相同的字符则窗口向右扩充一位
                    tempChar.add(characters[windowRight]);
                    windowRight++;
                }
            } else {
                if (flag || repeatChar.contains(characters[windowRight])) {
                    //若在窗口内找到相同的字符则整个窗口右移
                    repeatChar.add(characters[windowRight]);
                    windowRight++;
                    windowLeft++;
                    repeatChar.poll();
                } else {
                    //在窗口内没找到相同的字符则窗口向右扩充一位
                    repeatChar.add(characters[windowRight]);
                    windowRight++;
                }
            }
        }
        return windowRight - windowLeft;
    }

    /**
     * 上述方案的简化版
     * @param s String
     * @return  int
     */
    private static int lengthOfLongestSubstringWay(String s) {
        char[] characters = s.toCharArray();
        int windowLeft = 0;
        int windowRight = 0;
        Queue<Character> tempChar = new LinkedList<>();
        while (windowRight < characters.length) {
            //标志队列内是否有重复元素
            boolean flag = false;
            //判断队列内部是否有重复元素
            for (int i = 0; i < tempChar.size(); i++) {
                Character poll = tempChar.poll();
                if (tempChar.contains(poll)) {
                    flag = true;
                }
                tempChar.add(poll);
            }
            if (flag || tempChar.contains(characters[windowRight])) {
                //若在窗口内找到相同的字符则整个窗口右移
                tempChar.add(characters[windowRight]);
                windowRight++;
                windowLeft++;
                tempChar.poll();
            } else {
                //在窗口内没找到相同的字符则窗口向右扩充一位
                tempChar.add(characters[windowRight]);
                windowRight++;
            }

        }
        return windowRight - windowLeft;
    }

    public static void main(String[] args) {
        String s = "abcdaaa";
        System.out.println(lengthOfLongestSubstringWay(s));
    }
}
