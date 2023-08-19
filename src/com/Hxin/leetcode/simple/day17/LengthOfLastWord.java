package com.Hxin.leetcode.simple.day17;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * <p>
 * 输出：5
 * <p>
 * 解释：最后一个单词是“World”，长度为5。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "   fly me   to   the moon  "
 * <p>
 * 输出：4
 * <p>
 * 解释：最后一个单词是“moon”，长度为4。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "luffy is still joyboy"
 * <p>
 * 输出：6
 * <p>
 * 解释：最后一个单词是长度为6的“joyboy”。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/17 21:05
 */
public class LengthOfLastWord {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        final String[] s1 = s.split(" ");
        return s1[s1.length-1].length();
    }
}
