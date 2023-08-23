package com.Hxin.leetcode.middle.month1.day24;

import java.util.*;

/**
 * 你会得到一个字符串 s (索引从 0 开始)，你必须对它执行 k 个替换操作。替换操作以三个长度均为 k 的并行数组给出：indices, sources,
 * targets。要完成第 i 个替换操作:检查 子字符串  sources[i] 是否出现在 原字符串 s 的索引 indices[i] 处。
 * 如果没有出现， 什么也不做 。
 * 如果出现，则用 targets[i] 替换 该子字符串。
 * <p>
 * 例如，如果 s = "abcd" ， indices[i] = 0 , sources[i] = "ab"， targets[i] = "eee" ，那么替换的结果将是 "eeecd" 。
 * 所有替换操作必须 同时 发生，这意味着替换操作不应该影响彼此的索引。测试用例保证元素间不会重叠 。
 * <p>
 * 例如，一个 s = "abc" ，  indices = [0,1] ， sources = ["ab"，"bc"] 的测试用例将不会生成，因为 "ab" 和 "bc" 替换重叠。
 * 在对 s 执行所有替换操作后返回 结果字符串.子字符串 是字符串中连续的字符序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", indices = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
 * <p>
 * 输出："eeebffff"
 * <p>
 * 解释：
 * <p>
 * "a" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
 * "cd" 从 s 中的索引 2 开始，所以它被替换为 "ffff"。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abcd", indices = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
 * <p>
 * 输出："eeecd"
 * <p>
 * 解释：
 * <p>
 * "ab" 从 s 中的索引 0 开始，所以它被替换为 "eee"。
 * "ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/15 20:27
 */
public class FindReplaceString {
    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        System.out.println(findReplaceString(s, indices, sources, targets));
    }

    private static String replaceString(String s, int index, String target, int length) {
        String start = s.substring(0, index);
        String end = s.substring(index + length);
        return start + target + end;
    }

    private static boolean isMatch(String s, int index, String target) {
        int len = target.length();
        String source = "";
        if (index + len > s.length()) {
            source = s.substring(index);
        } else {
            source = s.substring(index, index + len);
        }
        return source.equals(target);
    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        //从后往前遍历
//        int loopTime = indices.length;
//        while (loopTime > 0) {
//            int nowMax = Integer.MIN_VALUE;
//            int j = 0;
//            for (int i = 0; i < indices.length; i++) {
//                if (nowMax <= indices[i]) {
//                    j = i;
//                    nowMax = indices[i];
//                }
//            }
//            //是否匹配
//            if (isMatch(s, indices[j], sources[j])) {
//                s = replaceString(s, indices[j], targets[j], sources[j].length());
//            }
//            indices[j] = Integer.MIN_VALUE;
//            loopTime -= 1;
//        }
//        -------------------------------------------------
//        Map<Integer, Integer> numMap = new HashMap<>();
//        for (int i = 0; i < indices.length; i++) {
//            numMap.put(i, indices[i]);
//        }
//        LinkedHashMap<Integer, Integer> resSortedMap = sortMap(numMap);


        int[] indexArray = new int[1000];
        Arrays.fill(indexArray, Integer.MIN_VALUE);
        for (int i = 0; i < indices.length; i++) {

            indexArray[indices[i]] = 0;
            indexArray[indices[i]] += i;
        }
        for (int i = indexArray.length - 1; i >= 0; i--) {
            if (indexArray[i] != Integer.MIN_VALUE && isMatch(s, indices[indexArray[i]], sources[indexArray[i]])) {
                s = replaceString(s, indices[indexArray[i]], targets[indexArray[i]], sources[indexArray[i]].length());
            }
        }
        return s;
    }

    private static LinkedHashMap<Integer, Integer> sortMap(Map<Integer, Integer> numMap) {
        //利用Map的entrySet方法，转化为list进行排序
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(numMap.entrySet());
        //利用Collections的sort方法对list排序
        entryList.sort((o1, o2) -> {
            //正序排列，倒序反过来
            return o2.getValue() - o1.getValue();
        });
        //遍历排序好的list，一定要放进LinkedHashMap，因为只有LinkedHashMap是根据插入顺序进行存储
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> e : entryList) {
            linkedHashMap.put(e.getKey(), e.getValue());
        }
        return linkedHashMap;
    }
}
