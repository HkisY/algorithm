package com.Hxin.leetcode.simple.day2;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 链接：https://leetcode.cn/problems/valid-parentheses
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/3 23:00 - 23.31
 */
public class IsValid {
    public static boolean isValid(String s) {
        if (s.length() <= 1) {
            return false;
        }
        Stack<Character> stringStack = new Stack<>();
        //初始压入栈中一个元素，为了省去空栈检测步骤。
//        stringStack.push('a');
        for (int i = 0; i < s.length(); i++) {
            if (stringStack.isEmpty()) {
                stringStack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ']' && stringStack.peek() == '[') {
                    stringStack.pop();
                } else if (s.charAt(i) == ')' && stringStack.peek() == '(') {
                    stringStack.pop();
                } else if (s.charAt(i) == '}' && stringStack.peek() == '{') {
                    stringStack.pop();
                } else {
                    stringStack.push(s.charAt(i));
                }
            }
        }
//        return stringStack.size() == 1;
        return stringStack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(isValid(s));
    }
}
