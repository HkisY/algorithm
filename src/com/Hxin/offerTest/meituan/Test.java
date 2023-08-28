package com.Hxin.offerTest.meituan;

import java.util.*;

/**
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/8/25  22:46
 */
public class Test {
    public static void main(String[] args) {
        int[][] a = {{1,3},{2,5},{0,1},{3,5},{56,67},{10,11}};
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }
    }
}
