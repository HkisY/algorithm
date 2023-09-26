package com.Hxin.markableQus.calculate;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * <p>
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * <p>
 * s 表示一个有效的表达式
 * <p>
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * <p>
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * <p>
 * 输入中不存在两个连续的操作符
 * <p>
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/26  15:07
 */
public class CalculateOne {
    public static void main(String[] args) {
//        1 1 1 1 -1 -1 1 1
        String s = "1+1+2+3+21-(1+1-(1+1))";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
//        Stack<Integer> op = new Stack<>();
//        Stack<Integer> number = new Stack<>();
//        int num = 0;
//        int signal = 1;
//        char[] charArray = s.toCharArray();
//        for (int i = 0; i < charArray.length; i++) {
//            if (Character.isDigit(charArray[i])) {
//                num = num * 10 + (charArray[i] - '0');
//                if (i == charArray.length - 1) {
//                    number.push(num);
//                }
//            } else {
//                if (num !=0){
//                    number.push(num);
//                }
//                num = 0;
//                if (charArray[i] == '(') {
//                    if (charArray[i-1] == '-') {
//                        signal = -signal;
//                    }
//                } else if (charArray[i] == '+') {
//                    if (signal == 1) {
//                        op.push(1);
//                    } else {
//                        op.push(-1);
//                    }
//                } else if (charArray[i] == '-') {
//                    if (signal == -1) {
//                        op.push(1);
//                    } else {
//                        op.push(-1);
//                    }
//                } else if (charArray[i] == ')') {
//                    if (signal == -1) {
//                        signal = -signal;
//                    }
//                }
//            }
//        }
//        while (!op.isEmpty()) {
//            if (op.pop() == 1) {
//                Integer num1 = number.pop();
//                Integer num2 = number.pop();
//                number.push(num1 + num2);
//            } else if (op.pop() == -1) {
//                Integer num1 = number.pop();
//                Integer num2 = number.pop();
//                number.push(num2 - num1);
//            }
//        }
//        return number.pop();
//

        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
