package com.Hxin.markableQue.calculationQue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 772
 * <p>
 * 实现一个基本的计算器来计算简单的表达式字符串。
 * <p>
 * 表达式字符串只包含非负整数，算符 +、-、*、/ ，左括号 ( 和右括号 ) 。整数除法需要 向下截断 。
 * <p>
 * 你可以假定给定的表达式总是有效的。所有的中间结果的范围均满足 [-231, 231 - 1] 。
 * <p>
 * 注意：你不能使用任何将字符串作为表达式求值的内置函数，比如 eval() 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1+1"
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "6-4/2"
 * 输出：4
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "2*(5+5*2)/3+(6/2+8)"
 * 输出：21
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s <= 104
 * <p>
 * s 由整数、'+'、'-'、'*'、'/'、'(' 和 ')' 组成
 * <p>
 * s 是一个 有效的 表达式
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/26  17:34
 */
public class CalculateThree {
    public static void main(String[] args) {

    }

    public static int calculate(String s) {
        final int[] js = js(s, 0);
        return js[0];
    }

    public static int[] js(String s,int begin) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[2];
        char presign = '+';
        int n = s.length();
        int num = 0;
        for (int i = begin; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                int[] numNext = js(s,i + 1);
                num = numNext[0];
                i = numNext[1];
            }
            //对于末尾结束时 或 不是数字字符且字符不为'('时，对num进行处理
            if (i == n - 1 || !Character.isDigit(c) && c != '(') {
                switch (presign) {
                    case '+' -> deque.push(num);
                    case '-' -> deque.push(-num);
                    case '*' -> deque.push(deque.pop() * num);
                    default -> deque.push(deque.pop() / num);
                }
                //如果结束是右括号，那么就记录位置结束循环。
                if (c == ')') {
                    result[1] = i;
                    break;
                }
                presign = c;
                num = 0;
            }

        }
        while (!deque.isEmpty()) {
            result[0] += deque.pop();
        }
        return result;
    }
}
