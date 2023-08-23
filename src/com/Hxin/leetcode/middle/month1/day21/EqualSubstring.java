package com.Hxin.leetcode.middle.month1.day21;

/**
 * 给你两个长度相同的字符串，s 和 t。
 * <p>
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * <p>
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * <p>
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * <p>
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "bcdf", maxCost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 * <p>
 * 输入：s = "abcd", t = "cdef", maxCost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/9 21:01
 */
public class EqualSubstring {
    public static void main(String[] args) {
        //107 114 114 103 119
        String s = "a";
        //122 106 120 115 115
        String t = "a";
        int maxCost = 0;
        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        final char[] charsSource = s.toCharArray();
        final char[] charsTarget = t.toCharArray();
        int charsLength = charsSource.length;
        int[] difference = new int[charsLength];
        for (int i = 0; i < charsLength; i++) {
            difference[i] = Math.abs(charsSource[i] - charsTarget[i]);
        }
        int totalCost = 0;
        int left = 0, right;
        for (right = 0; right < charsLength; right++) {
            totalCost += difference[right];
            if (totalCost > maxCost) {
                totalCost -= difference[left++];
            }
        }
        return right - left;
    }

    private static int findMaxLength(int[] nums, int maxCost) {
        int preSumEnd = 0, preSumStart = 0;
        int start = 0, end = 0;
        int res = 0;
        while (end < nums.length) {
            if (preSumEnd + nums[end] - preSumStart <= maxCost) {
                preSumEnd += nums[end];
                end++;
            } else {
                preSumStart += nums[start];
                start++;
            }
            res = Math.max(end - start, res);
        }
        return res;
    }
}
