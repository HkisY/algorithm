package com.Hxin.leetcode.middle.month1.day18;

/**
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果needle 不是
 * haystack 的一部分，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * <p>
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/6/25 21:27
 */
public class StrStr {
    public static void main(String[] args) {
        String a = "mississippi";
        String b = "issipi";
        System.out.println(strStr(a, b));
    }

    private static int strStr(String haystack, String needle) {
        final char[] haystackChars = haystack.toCharArray();
        final char[] needleChars = needle.toCharArray();
        int loopLength = haystackChars.length;
        int start = 0, end = needleChars.length;
        if (loopLength < end) {
            return -1;
        }
        int finalRes = -1;
        for (int i = 0; i < loopLength - end+1; i++) {
            int pointTemp = i;
            while (haystackChars[pointTemp] == needleChars[start]) {
                pointTemp++;
                start++;
                if (start == end) {
                    break;
                }
            }
            if (start == end) {
                finalRes = i;
                break;
            } else start = 0;
        }
        return finalRes;
    }
}
