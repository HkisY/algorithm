package com.Hxin.offerTest.tencent2;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/15 20:49
 */
public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loopTime = Integer.parseInt(sc.nextLine().split(" ")[0]);
        for (int i = 0; i < loopTime; i++) {
            int lines = Integer.parseInt(sc.nextLine().split(" ")[0]);
            String[] strings = new String[lines];
            for (int j = 0; j < lines; j++) {
                strings[j] = sc.nextLine();
            }
//            处理逻辑
            boolean flag = false;
//            for (int j = 0; j < lines; j++) {
//                if (flag) {
//                    break;
//                }
//                for (int k = j + 1; k < lines; k++) {
//                    if (flag) {
//                        break;
//                    }
//                    flag = getAns(strings[j], strings[k]);
//                }
//            }
            int[][] numsAra = new int[lines][strings[0].length()];
            for (int j = 0; j < lines; j++) {
                for (int k = 0; k < strings[0].length(); k++) {
                    numsAra[j][k] = strings[j].charAt(k)-'a';
                }
            }
            for (int j = 0; j < lines; j++) {
                for (int k = 0; k < lines; k++) {

                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    private static boolean getAns(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int time = a.length();
        int loop = 0;
        while (loop < time) {
            if (sb.toString().equals(b)) {
                return true;
            } else {
                final char c = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(c);
            }
            loop++;
        }
        return false;

    }
}
