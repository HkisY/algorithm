package com.Hxin.offerTest.xiaomi;

import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/23 16:53
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int towerLength = Integer.parseInt(input[0]);
        int radius = Integer.parseInt(input[1]);
        int[][] content = new int[towerLength][3];
        int leftX = 0, upY = 0, rightX = 0, downY = 0;
        for (int i = 0; i < towerLength; i++) {
            String[] input1 = sc.nextLine().split(",");
            content[i][0] = Integer.parseInt(input1[0]);
            content[i][1] = Integer.parseInt(input1[1]);
            rightX = Math.max(rightX, content[i][0]);
            upY = Math.max(upY, content[i][1]);
            leftX = Math.min(leftX, content[i][0]);
            downY = Math.min(downY, content[i][1]);
            content[i][2] = Integer.parseInt(input1[2]);
        }
        int ans = -1;
        int finalDis = 0;
        int ansX = 0;
        int ansY = 0;
        for (int i = leftX; i <= rightX; i++) {
            for (int j = downY; j < upY; j++) {
                int tempAns = 0;
                for (int k = 0; k < towerLength; k++) {
                    int x = content[k][0];
                    int y = content[k][1];
                    int value = content[k][2];
                    float distance = (float) Math.sqrt(Math.pow((i - x), 2) + Math.pow((j - y), 2));
                    if (distance <= value) {
                        tempAns += (int) (value / ((float)1 + distance));
                    }
                }
                if (tempAns > finalDis) {
                    finalDis = tempAns;
                    ansX = i;
                    ansY = j;
                } else if (tempAns == finalDis) {
                    if (i < ansX) {
                        ansX = i;
                        ansY = j;
                    } else if (i == ansX) {
                        if (j < ansY) {
                            ansY = j;
                        }
                    }
                }
            }
        }
        System.out.print(ansX + "," + ansY);
    }
}
