package com.Hxin.offerTest.redBook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/8/6 14:37
 */
public class RedBookTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.equals("")) break;
            list.add(s);
        }
        for (String value : list) {
            final String[] s = value.split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            ArrayList<Integer> res = solution(n, m);
            if (res.size() == 0){
                System.out.println("no");
            }else {
                for (Integer re : res) {
                    System.out.print(re + " ");
                }
            }

        }
    }

    private static ArrayList<Integer> solution(int n, int m) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = n; i <= m; i++) {
            if (judgeNum(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private static boolean judgeNum(int i) {
        int[] temp = new int[3];
        int originNum = i;
        for (int j = 0; j < 3; j++) {
            temp[j] = i - i / 10 * 10;
            i = i / 10;
        }
        int sum = 0;
        for (int j : temp) {
            sum += j * j * j;
        }
        return sum == originNum;
    }


}
