package com.Hxin.nowcoder.huawei.day1;

import java.util.Stack;

/**
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/20  16:52
 */
public class IsValidPairing {
    public static void main(String[] args) {
        System.out.println(isValidPairingByStack("ACDB"));
    }

    public static boolean isValidPairing(String s) {
        // write code here\
        if (s.length() % 2 == 1) {
            return false;
        }
        int[] flag = new int[s.length()];
        int indexNum = 1;
        for (int i = 0; i < s.length(); i++) {
            if (flag[i] == 1) {
                continue;
            }
            if (s.charAt(i) == 'A') {
                if (s.charAt(i + 1) == 'B') {
                    flag[i] = 1;
                    flag[i + 1] = 1;
                    indexNum += 2;
                }
            } else if (s.charAt(i) == 'C') {
                if (s.charAt(i + 1) == 'D') {
                    flag[i] = 1;
                    flag[i + 1] = 1;
                    indexNum += 2;
                }
            } else if (s.charAt(i) == 'B') {
                if (i - indexNum < 0) {
                    return false;
                }
                if (s.charAt(i - indexNum) == 'A') {
                    flag[i] = 1;
                    flag[i - indexNum] = 1;
                    indexNum += 2;

                }
            } else if (s.charAt(i) == 'D') {
                if (i - indexNum < 0) {
                    return false;
                }
                if (s.charAt(i - indexNum) == 'C') {
                    flag[i] = 1;
                    flag[i - indexNum] = 1;
                    indexNum += 2;
                }
            }
        }
        return indexNum - 1 == s.length();
    }

    public static boolean isValidPairingByStack(String s) {
        Stack<Character> stack = new Stack<>();
        final char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.isEmpty()) {
                stack.push(aChar);
            } else {
                if (aChar == 'B') {
                    if (stack.peek() == 'A') {
                        stack.pop();
                    } else {
                        stack.push(aChar);
                    }
                } else if (aChar == 'D') {
                    if (stack.peek() == 'C') {
                        stack.pop();
                    } else {
                        stack.push(aChar);
                    }
                }else {
                    stack.push(aChar);
                }
            }

        }
        return stack.isEmpty();
    }
}
