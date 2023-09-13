package com.Hxin.offerTest.baidu;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/12 18:53
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loopTime = sc.nextInt();
        for (int i = 0; i < loopTime; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
//            处理逻辑
            boolean tag = findTheAns(n, m);
            if (tag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    // n*m 的棋盘
    private static boolean findTheAns(int n, int m) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && (m - i) % 2 == 1) {
                    dp[i][j] = 0;
                }
                if (j == m - 1 && (n - i) % 2 == 1) {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[0][0] == 0;
    }
}
