package com.Hxin.leetcode.hard.month2.day1;

import java.util.Stack;

/**
 * 32
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/10  13:56
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = "()(()";
        System.out.println(longestValidParentheses(s));

    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        final char[] charArray = s.toCharArray();
        stack.add(-1);
        int length = 0;
        int maxLength = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.add(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(i);
                } else {
                    length = i - stack.peek();
                    maxLength = Math.max(length, maxLength);
                }
            }

        }
        return maxLength;
    }

    public static int longestValidParenthesesByDP(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
