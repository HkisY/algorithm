package com.Hxin.leetcode.middle.month2.day11;

/**
 * 38
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/22  15:08
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = getTempString(s);
        }
        return s;
    }

    private static String getTempString(String string) {
        final char[] charArray = string.toCharArray();
        StringBuilder ans = new StringBuilder();
        int num = 0,number = charArray[0]-'0';
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i]-'0' == number) {
                num++;
            } else {
                ans.append(num).append(number);
                number = charArray[i]-'0';
                num = 1;
            }
            if (i == charArray.length-1){
                ans.append(num).append(number);
            }
        }
        return ans.toString();
    }
}
