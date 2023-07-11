package com.Hxin.algorithm.assignment3;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/23
 */
public class MazeSolving {
    public static void main(String[] args) {
        int[][] flag = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1}
        };
        int[][] result = new int[5][5];
        dfs(0, flag, result, 0, 0);

    }

    public static void dfs(int count, int[][] flag, int[][] result, int xPos, int yPos) {
        if (count > 8) {    // can also change the destination position
            for (int[] i : result) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.print("\n");
            }
            System.out.println("-----------------");
            return;
        }
        if (xPos < flag.length && yPos < flag.length) {
            if (flag[xPos][yPos] != 0) {
                result[xPos][yPos] = 1;
                if (count == 8){    //can also judge the destination position
                    //standard output
                    dfs(count + 1, flag, result, xPos, yPos + 1);
                }else {
                    //right step
                    dfs(count + 1, flag, result, xPos, yPos + 1);
                    //down step
                    dfs(count + 1, flag, result, xPos + 1, yPos);
                }
                result[xPos][yPos] = 0;
            }
        }
    }
}
