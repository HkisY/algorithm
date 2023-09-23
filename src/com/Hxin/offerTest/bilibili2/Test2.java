package com.Hxin.offerTest.bilibili2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/23 19:40
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "25525511135";
        String[] s1 = new String[10];
           s1 = GetIPList(s);
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
    }

    public static String[] GetIPList(String s) {
        // write code here
        List<String> result = new ArrayList<>();
        generateIP(s, 0, new ArrayList<>(), result);
        String[] ans = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private static void generateIP(String s, int start, ArrayList<String> current, List<String> result) {
        if (current.size() == 4 && start == s.length()) {
            result.add(String.join(".", current));
            return;
        }
        for (int i = start; i < s.length() && i < start + 3; i++) {
            String segment = s.substring(start, i + 1);
//            验证合法性
            if (isLegalSegment(segment)) {
                current.add(segment);
                generateIP(s, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isLegalSegment(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}
