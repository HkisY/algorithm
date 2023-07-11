package com.Hxin.leetcode.middle.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 链接：https://leetcode.cn/problems/generate-parentheses
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/6/5 20:14-22.13
 */
public class GenerateParenthesis {
    //回朔法
    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // 0 表示左括号，1表示右括号
        int[] targets = new int[2 * n];
        dfs(2 * n, 1,  targets, result);
        return result;
    }

    private static void dfs(int n, int depth, int[] targets, List<String> result) {
        if (depth > n) {
            if (judgeLegal(targets)) {
                StringBuilder sb = new StringBuilder();
                for (int target : targets) {
                    if (target == 0) {
                        sb.append("(");
                    } else sb.append(")");
                }
                result.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i <= 1; i++) {
            targets[depth - 1] = i;
            dfs(n, depth + 1,  targets, result);
        }
    }

    private static boolean judgeLegal(int[] targets) {
        //判断开始喝
        if (targets[0] == 1 || targets[targets.length - 1] == 0) {
            return false;
        }
        //验证括号数量
        int left = 0, right = 0;
        for (int j : targets) {
            if (j == 0) {
                left++;
            } else right++;
        }
        if (left != right) {
            return false;
        }
        //验证括号匹配
        Stack<Integer> stack = new Stack<>();
        for (int target : targets) {
            if (stack.isEmpty()) {
                if (target == 1) {
                    return false;
                }
                stack.push(target);
            } else {
                if (stack.peek() == 0 && target == 1) {
                    stack.pop();
                } else {
                    stack.push(target);
                }
            }
        }
        return stack.isEmpty();
    }

    public List<String> generateParenthesisWay(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
