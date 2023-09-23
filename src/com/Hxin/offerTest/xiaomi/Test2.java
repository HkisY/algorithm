package com.Hxin.offerTest.xiaomi;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/23 17:10
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = Integer.parseInt(sc.nextLine());
        final String[] split = sc.nextLine().split(",");
        int[][] subject = new int[time][time];
        for (int i = 0; i < split.length; i++) {
            final String[] split1 = split[i].split(":");
            subject[Integer.parseInt(split1[0])][Integer.parseInt(split1[0])] = 1;
        }
        boolean ans = true;
        for (int i = 0; i < time; i++) {

            int[][] flag = new int[time][time];
            for (int j = 0; j < time; j++) {
                if (flag[i][j] == 1){
                    ans = true;
                    break;
                }
                if (subject[i][j] == 1 && flag[i][j] == 0) {
                    flag[i][j] = 1;
                    i = j;
                } else if (subject[i][j] == 0 && i != j) {
                    ans = false;
                    break;
                }
            }


        }
        if (ans){
            System.out.println(0);
        }else {
            System.out.println(1);
        }
    }
}
