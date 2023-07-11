package com.Hxin.algorithm.assignment2;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/24
 */
public class RollingDice {
    private static int sum = 0;
    private static int time = 0;
    private static int targetNum;
    private static int[] result = new int[6];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        targetNum = sc.nextLine().charAt(0) - '0';
        System.out.println(solution(0));

    }

    public static int solution(int n) {
        int upperBound = targetNum;
        solution(n, upperBound);
        return time;
    }

    private static void solution(int n, int upperBound) {
        if (n <= upperBound) {
            for (int i = 0; i < n; i++) {
                sum += result[i];
            }
            if (sum == upperBound) {
                time++;
                sum = 0;
                return;
            } else if (sum > upperBound) {
                sum = 0;
                return;
            }
            sum = 0;
        }

        for (int i = 0; i < upperBound; i++) {
            result[n] = i + 1;
            solution(n + 1, upperBound);
        }
    }
}
