package com.Hxin.leetcode.hard.day13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。
 * "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/13 12:35
 */
public class FindSubstring {
    public static void main(String[] args) {
        String s = "        ";
        String[] words = {"word", "good", "best", "word"};
        System.out.println(findSubstring(s, words).toString());
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resList = new ArrayList<>();
        int wordArrayNum = words.length;
        int singleWordNum = words[0].length();

        for (int i = 0; i <= s.length() - wordArrayNum * singleWordNum; i += 1) {
            Map<String, Integer> pattern = new HashMap<>();
            for (String word : words) {
                if (pattern.containsKey(word)) {
                    Integer integer = pattern.get(word);
                    integer += 1;
                    pattern.put(word, integer);
                } else {
                    pattern.put(word, 1);
                }
            }
            String tempString = s.substring(i, i + wordArrayNum * singleWordNum);
            for (int j = 0; j < tempString.length(); j += singleWordNum) {
                final String substring = tempString.substring(j, j + singleWordNum);
                if (pattern.containsKey(substring)) {
                    if (pattern.get(substring) > 0) {
                        if (j == tempString.length() - singleWordNum) {
                            resList.add(i);
                        }
                        Integer integer = pattern.get(substring);
                        integer -= 1;
                        pattern.put(substring, integer);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return resList;
    }
}
