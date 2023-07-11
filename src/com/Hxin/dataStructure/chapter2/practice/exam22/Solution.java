package com.Hxin.dataStructure.chapter2.practice.exam22;

import com.Hxin.dataStructure.chapter2.stackADT.ArrayStackByMe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * exam 22 exam 23
 *
 * @author Hxin
 * @version 1.0
 * @since 2022/4/10
 */
public class Solution {
    public static void main(String[] args) {
//        String calculation = "a+b*c+(d*e+f)*g";
        String calculation = "6*(5+(2+3)*8+3)";

        String result = infixToPostfix(calculation);
        //后缀表达式
        System.out.println(result);
        System.out.println(postfixCalculation(result));
        System.out.println(postfixToInfix(result));
    }

    //双位数并不支持
    public static String infixToPostfix(@NotNull String s) {
        StringBuilder sb = new StringBuilder();
        ArrayStackByMe<Character> stack = new ArrayStackByMe<>();
        char[] chars = s.toCharArray();

        ArrayList<Character> tempOperator = new ArrayList<>();
        for (char c : chars) {
            if (c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.hasNext() && stack.top() != '(') {
                    sb.append(stack.top());
                    stack.pop();
                }
                if (stack.hasNext() && stack.top() == '(') {
                    stack.pop();
                }
            } else if (c == '+' || c == '-') {
                //比加减号优先级高的操作符全部出栈
                while (stack.hasNext() && (stack.top() == '+' || stack.top() == '-' || stack.top() == '*' || stack.top() == '/') && stack.top() != '(') {
                    sb.append(stack.top());
                    stack.pop();
                }
                stack.push(c);
            } else {
                //比乘除优先级高的操作符全部出栈
                while (stack.hasNext() && (stack.top() == '*' || stack.top() == '/') && stack.top() != '(') {
                    sb.append(stack.top());
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while (stack.hasNext()) {
            sb.append(stack.top());
            stack.pop();
        }
        return sb.toString();
    }

    public static int postfixCalculation(@NotNull String s) {
        int value = 0;
        ArrayStackByMe<Integer> stack = new ArrayStackByMe<>();
        for (char c : s.toCharArray()) {
            if (c != '+' && c != '-' && c != '*' && c != '/') {
                //char 转 int
                stack.push(c - '0');
            } else {
                value = stack.pop();
                if (c == '+') {
                    value += stack.pop();
                } else if (c == '-') {
                    value -= stack.pop();
                } else if (c == '*') {
                    value *= stack.pop();
                } else {
                    value /= stack.pop();
                    ;
                }
                stack.push(value);
            }

        }
        return stack.top();
    }

    public static String postfixToInfix(@NotNull String s) {
        ArrayStackByMe<String> stack = new ArrayStackByMe<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '+' && chars[i] != '-' && chars[i] != '*' && chars[i] != '/') {
                stack.push(String.valueOf(chars[i]));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("(").append(stack.pop()).append(chars[i]).append(stack.pop()).append(")");
                stack.push(sb.toString());
            }
        }
        //翻转字符串,下述方法并未对括号的开闭进行处理
        // return new StringBuilder(stack.pop()).reverse().toString();

        Reverse reverse = new Reverse(stack.pop());
        return Reverse.reverse();
    }

    //standard answer
    static double evalPostFix() {
        Stack<Double> s = new Stack<Double>();
        String token;
        double a, b, result = 0.0;
        boolean isNumber;

        Scanner sc = new Scanner(System.in);
        token = sc.next();
        while (token.charAt(0) != '=') {
            //根据数据类型转换判断是否为数字
            try {
                isNumber = true;
                result = Double.parseDouble(token);
            } catch (Exception e) {
                isNumber = false;
            }
            if (isNumber) s.push(result);
            else {
                switch (token.charAt(0)) {
                    case '+':
                        a = s.pop();
                        b = s.pop();
                        s.push(a + b);
                        break;
                    case '-':
                        a = s.pop();
                        b = s.pop();
                        s.push(a - b);
                        break;
                    case '*':
                        a = s.pop();
                        b = s.pop();
                        s.push(a * b);
                        break;
                    case '/':
                        a = s.pop();
                        b = s.pop();
                        s.push(a / b);
                        break;
                    case '^':
                        a = s.pop();
                        b = s.pop();
                        s.push(Math.exp(a * Math.log(b)));
                        break;
                }

            }

            token = sc.next();
        }

        return s.peek();
    }

    //standard answer
    static void InFixToPostFix() {
        Stack<Character> s = new Stack<>();
        String expression;
        Character token;
        int i = 0;

        Scanner sc = new Scanner(System.in);
        expression = sc.next();

        while ((token = expression.charAt(i++)) != '=') {
            if (token >= 'a' && token <= 'z') System.out.print(token + " ");
            else {
                switch (token) {
                    case ')':
                        while (!s.empty() && s.peek() != '(') {
                            System.out.print(s.pop() + " ");
                        }
                        s.pop();
                        break;
                    case '(':
                        s.push(token);
                        break;
                    case '^':
                        while (!s.empty() && !(s.peek() == '^' ||
                                s.peek() == '(')) {
                            System.out.print(s.pop());
                        }
                        s.push(token);
                        break;
                    case '*':
                    case '/':
                        while (!s.empty() && s.peek() != '+' &&
                                s.peek() != '-' && s.peek() != '(') {
                            System.out.print(s.pop());
                        }
                        s.push(token);
                        break;
                    case '+':
                    case '-':
                        while (!s.empty() && s.peek() != '(') {
                            System.out.print(s.pop() + " ");
                        }
                        s.push(token);
                        break;
                }
            }
        }

        while (!s.empty()) {
            System.out.print(s.pop());
        }
        System.out.println();
    }

    static class Reverse {
        private static String s;

        Reverse(String s) {
            Reverse.s = s;
        }

        public static String reverse() {
            char[] chars = s.toCharArray();
            StringBuilder result = new StringBuilder();
            for (int i = chars.length - 1; i >= 0; --i) {
                if (chars[i] == '(') {
                    result.append(")");
                } else if (chars[i] == ')') {
                    result.append("(");
                } else {
                    result.append(chars[i]);
                }
            }
            return result.toString();
        }
    }
}
