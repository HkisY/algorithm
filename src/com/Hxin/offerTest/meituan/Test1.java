package com.Hxin.offerTest.meituan;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/8/26 10:02
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int water = sc.nextInt();
        int shiFei = sc.nextInt();
        int target = sc.nextInt();
        int res = 0;
        int loop = target / (water * 3 + shiFei);
        int i = target % (water * 3 + shiFei);
        res += loop * 3;
        if (i > 0 && i <= shiFei + water) {
            res += 1;
        } else if (i > 0 && i <= shiFei + water * 2) {
            res += 2;
        } else if (i > 0 && i <= shiFei + water * 3) {
            res += 3;
        }
        System.out.println(res);
    }
}
