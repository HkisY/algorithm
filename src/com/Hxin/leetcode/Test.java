package com.Hxin.leetcode;

import java.util.HashSet;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/5/2
 */
public class Test {
    public static void main(String[] args) {
        int x = 7;
        System.out.println(x%3);
        System.out.println(x/3);
//        StringBuilder[] temp = new StringBuilder[4];
//        temp[0].append('c');
//        for (int i = 0; i < temp.length; i++) {
//            System.out.println(temp);
//            System.out.println('\n');
//        }
        StringBuilder[] sb = new StringBuilder[6];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        sb[1].append('c');
        for (StringBuilder stringBuilder : sb) {
            System.out.println(stringBuilder);
            System.out.println("-------");
        }
    }
}
