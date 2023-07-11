package com.Hxin.leetcode.simple.day1;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 整型数字判断回文
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/2
 */
public class Palindrome {
    /**
     * @param x 入参
     * @return boolean
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        ArrayList<Integer> numList = new ArrayList<>();
        int num = x;
        do {
            numList.add(num % 10);
            num = num / 10;
        } while (num > 0);
        for (int i = 0; i < numList.size(); i++) {
            if (!Objects.equals(numList.get(i), numList.get(numList.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeWay2(int x) {
        String num = String.valueOf(x);
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a = 1243421;
        System.out.println(isPalindromeWay2(a));
    }
}
