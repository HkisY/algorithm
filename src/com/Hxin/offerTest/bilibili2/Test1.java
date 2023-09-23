package com.Hxin.offerTest.bilibili2;

import java.util.Stack;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/23 18:58
 */
public class Test1 {
    private static int index = 0;

    public static void main(String[] args) {
        String s = "11111 + 111 + 1 + (111 + 111 + 1)";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
//         write code here
        int len = s.length();
        if (s.isEmpty()) {
            return 0;
        }
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                values.push(num);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    int num2 = values.pop();
                    int num1 = values.pop();
                    values.push(applyOperator(num1, num2, operators.pop()));
                }
                operators.push(c);
                i++;
            } else if (c == '(') {
                operators.push(c);
                i++;
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    int num2 = values.pop();
                    int num1 = values.pop();
                    values.push(applyOperator(num1, num2, operators.pop()));
                }
                operators.pop();
                i++;
            } else {
                i++;
            }
        }
        while (!operators.isEmpty()) {
            int num2 = values.pop();
            int num1 = values.pop();
            values.push(applyOperator(num1, num2, operators.pop()));
        }
        return values.pop();
    }

    private static int applyOperator(int num1, int num2, char operator) {
        switch (operator){
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            case '/':
                return num1/num2;
            default:
                throw new IllegalStateException("not legal opt");
        }
    }

    private static boolean hasPrecedence(char op1, char op2) {
        return (op2 == '*' || op2 == '/') && (op1 == '+' || op1 == '-');
    }
}
