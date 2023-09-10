package com.Hxin.leetcode.hard.month2.day1;

import com.Hxin.leetcode.middle.month2.day3.Insert;

import java.util.Stack;

/**
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/10  14:40
 */
public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(1);
        stack.add(1);
        stack.add(1);
        System.out.println(   stack.size());
        System.out.println(   stack.capacity());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(   stack.size());
        System.out.println(   stack.capacity());

    }
}
