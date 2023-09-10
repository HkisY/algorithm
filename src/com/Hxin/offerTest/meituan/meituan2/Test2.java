package com.Hxin.offerTest.meituan.meituan2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/2 19:16
 */
public class Test2 {
    private static char[] target = {'m', 'e', 'i', 't', 'u', 'a', 'n'};
    private static void sort(){
        Arrays.sort(target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String[] s = sc.nextLine().split(" ");
        int rowLen = s[0].toCharArray()[0]-'0';
        int colLen = s[1].toCharArray()[0]-'0';
        char[][] chars = new char[rowLen][colLen];
        int index = 0;
        while (sc.hasNextLine()) {
            char[] c = sc.nextLine().toCharArray();
            chars[index] = c;
            index++;
            if (index == rowLen){
                break;
            }
        }
//        char[][] chars = {{'n','m'},{'e','x'},{'i','t'},{'t','d'},{'u','l'},{'q','u'},{'a','c'},{'n','t'}};
        boolean end = false;
        int[] flag = new int[8];
        StringBuilder sb = new StringBuilder();
        dfs(0, chars, flag, end, sb);
        System.out.println(end?"Yes":"No");
    }

    public static void dfs(int count, char[][] chars, int[] flag, boolean end, StringBuilder res) {
        if (end) {
            return;
        }
        if (count == chars.length) {
            boolean a = judge(res);
            if (a) {
                end = true;
                System.out.println("Yes");
            }
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                for (int j = 0; j < chars[i].length; j++) {
                    res.append(chars[i][j]);
                    dfs(count + 1, chars, flag, end, res);
                    res.deleteCharAt(count);
                }
                flag[i] = 0;
            }
        }
    }

    private static boolean judge(StringBuilder res) {
        final char[] chars = res.toString().toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]!=target[i]){
                return false;
            }
        }
        return true;
    }
}
