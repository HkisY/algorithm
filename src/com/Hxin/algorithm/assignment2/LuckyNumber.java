package com.Hxin.algorithm.assignment2;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/24
 */
public class LuckyNumber {
    private static int num = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            final int i = Integer.parseInt(sc.nextLine());
            System.out.println(solution(i));
        }
    }

    public static int solution(int n) {
        return solution(1, n);
    }

    private static int sumBinary(int num) {
        int result = 0;
        String s = Integer.toBinaryString(num);
        for (char c : s.toCharArray()) {
            result += c - '0';
        }
        return result;
    }

    private static int sumDecimal(int num) {
        int result = 0;
        while (num % 10 != num) {
            result += num % 10;
            num /= 10;
        }
        return result + num;
    }

    private static int solution(int startIndex, int endIndex) {
        if (startIndex == endIndex){
            if (sumBinary(startIndex) == sumDecimal(startIndex)) {
//                System.out.println(startIndex);
                num++;
            }
            return num;
        }

        int middle = (startIndex + endIndex) / 2;
        solution(startIndex, middle);
        solution(middle + 1, endIndex);
        return num;
    }
}
