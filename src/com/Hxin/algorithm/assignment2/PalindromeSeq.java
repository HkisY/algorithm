package com.Hxin.algorithm.assignment2;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/24
 */
public class PalindromeSeq {
    private static int num = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> array = new LinkedList<>();
        int m = Integer.parseInt( sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        for (String c:s){
            array.add( c.charAt(0)-'0');
        }

        System.out.println(solution(array));

    }

    public static int solution(List<Integer> input) {
        return solution(input, 0, input.size() - 1);
    }

    private static int solution(List<Integer> input, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return num;
        }
        if (input.get(startIndex) < input.get(endIndex)) {
            Integer removeFirst = input.remove(startIndex);
            Integer removeSecond = input.remove(startIndex);
            input.add(startIndex, removeFirst + removeSecond);
            num++;
            solution(input, startIndex, endIndex - 1);
        } else if (input.get(startIndex) > input.get(endIndex)) {
            Integer removeFirst = input.remove(endIndex);
            Integer removeSecond = input.remove(endIndex);
            input.add(endIndex, removeFirst + removeSecond);
            num++;
            solution(input, startIndex, endIndex - 1);
        } else {
            solution(input, startIndex + 1, endIndex - 1);
        }
        return num;


    }
}
