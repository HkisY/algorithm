package com.Hxin.dataStructure.chapter2.practice.exam21;

import com.Hxin.dataStructure.chapter2.stackADT.ArrayStackByMe;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/10
 */
public class Solution {
    private static final char[] symbol = {'/', '*', '(', ')', '[', ']', '{', '}'};

    public static void main(String[] args) {
        String correct = "(S[]s) {t[](10)r(i+){St(ba)}}";
        Solution.solution(correct);
        String wrong =   "(S[]s  {t[](10)r(i+ {St(ba) }";
        Solution.solution(wrong);

    }

    public static void solution(String s) {
        char[] source = s.toCharArray();
        ArrayStackByMe<Character> stack = new ArrayStackByMe<>();
        int flagSlash = 0;
        int flagStar = 0;
        int ignoreCode = 0;
        for (char c : source) {
            if (ignoreCode == 1 && c != '*' && c != '/') {
                continue;
            }
            if (c == symbol[0] && flagSlash == 0) {
                flagSlash += 1;
                stack.push(c);
            } else if (c == symbol[1] && flagStar == 0) {
                flagStar += 1;
                stack.push(c);
                if (flagSlash == 1) {
                    ignoreCode = 1;
                }
            } else if (c == symbol[2]) {
                stack.push(c);
            } else if (c == symbol[4]) {
                stack.push(c);
            } else if (c == symbol[6]) {
                stack.push(c);
            } else if (c == symbol[1] && flagStar == 1) {
                if (stack.top() != '*') {
                    System.out.println("缺少了符号或者符号不成对出现 " + stack.top());
                    stack.pop();

                    throw new IllegalStateException();
                } else {
                    stack.pop();
                    flagStar = 0;
                }
            } else if (c == symbol[0] && flagSlash == 1) {
                if (stack.top() != '/') {
                    System.out.println("缺少了符号或者符号不成对出现 " + stack.top());
                    stack.pop();

                    throw new IllegalStateException();
                } else {
                    stack.pop();
                    flagSlash = 0;
                    if (flagStar == 0){
                        ignoreCode = 0;
                    }
                }
            } else if (c == symbol[3]) {
                if (stack.top() != '(') {
                    System.out.println("缺少了符号或者符号不成对出现 " + stack.top());
                    throw new IllegalStateException();
                } else {
                    stack.pop();
                }
            } else if (c == symbol[5]) {
                if (stack.top() != '[') {
                    System.out.println("缺少了符号或者符号不成对出现 " + stack.top());
                    throw new IllegalStateException();
                } else {
                    stack.pop();
                }
            } else if (c == symbol[7]) {
                if (stack.top() != '{') {
                    System.out.println("缺少了符号或者符号不成对出现 " + stack.top());
                    throw new IllegalStateException();
                } else {
                    stack.pop();
                }
            }
        }
        if  (stack.size()!=0){
            while (stack.hasNext()){
                System.out.println("此符号没有成对出现 "+stack.top());
                stack.pop();
            }
        }
    }
}
