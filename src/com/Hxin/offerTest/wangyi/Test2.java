package com.Hxin.offerTest.wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/23 14:22
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len =Integer.parseInt(sc.nextLine());
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = sc.nextLine();
        }
        int res = countSimilarStr(strs);
        System.out.println(res);

    }

    private static int countSimilarStr(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (areSimilarStr(strs[i], strs[j])) {
                    count++;
                }
                ;
            }
        }
        return count;
    }

    private static boolean areSimilarStr(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        return map1.equals(map2);
    }
}
