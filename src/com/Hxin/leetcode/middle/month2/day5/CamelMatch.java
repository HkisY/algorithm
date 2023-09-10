package com.Hxin.leetcode.middle.month2.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * 1023
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/8  15:18-15:42
 */
public class CamelMatch {
    public static void main(String[] args) {
        String[] queries =
                {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        System.out.println(camelMatch(queries, pattern));

    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            if (matchPattern(query, pattern)) {
                res.add(true);
            } else res.add(false);
        }
        return res;
    }

    private static boolean matchPattern(String query, String pattern) {
        final char[] queryArray = query.toCharArray();
        final char[] patternArray = pattern.toCharArray();
        int patternStart = 0, queryStart = 0;
        while (queryStart < queryArray.length) {
            //越界
            if (patternStart == patternArray.length) {
                //小写
                if (queryArray[queryStart] - 'A' > 25) {
                    queryStart++;
                } else return false;
            } else {
                //判断是否为大写
                if (queryArray[queryStart] - 'A' <= 25) {
                    //大写且匹配
                    if (queryArray[queryStart] == patternArray[patternStart]) {
                        patternStart++;
                        queryStart++;
                    } else return false;
                    //大写不匹配
                } else {
                    //小写不匹配
                    if (queryArray[queryStart] != patternArray[patternStart]) {
                        queryStart++;
                    } else {//小写匹配
                        patternStart++;
                        queryStart++;
                    }
                }
            }
        }
        return patternStart == patternArray.length;
    }
}
