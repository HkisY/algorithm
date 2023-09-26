package com.Hxin.markableQue.calculationQue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 227
 * <p>
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * <p>
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * <p>
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * <p>
 * s 表示一个 有效表达式
 * <p>
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * <p>
 * 题目数据保证答案是一个 32-bit 整数
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/26  16:00
 */
public class CalculateTwo {
    public static void main(String[] args) {

    }

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
