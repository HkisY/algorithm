package com.Hxin.offerTest.meituan;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/8/26 10:18
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int peopleNum = sc.nextInt();
        int[] peopleSpt = new int[peopleNum];
        if (peopleNum == 1) {
            System.out.print(0);
        } else {
            for (int i = 0; i < row; i++) {
                int orderPeo = sc.nextInt();
                int sptNum = sc.nextInt();
                int sptOne = 0;
                if (sptNum % orderPeo != 0) {
                    sptOne = sptNum / orderPeo + 1;
                } else {
                    sptOne = sptNum / orderPeo;
                }
                for (int j = 0; j < orderPeo - 1; j++) {
                    int peopleIndex = sc.nextInt();
                    peopleSpt[peopleIndex - 1] += sptOne;
                }
            }
            for (int j : peopleSpt) {
                System.out.println(j + " ");
            }
        }
    }
}
