package com.Hxin.algorithm.assignment3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/23
 */
public class Test {
    public static void main(String[] args) {
        int[][] result = new int[5][5];
        int[][] flag = new int[5][5];
        Set[] setsLine = new Set[5];
        for (int i = 0; i < setsLine.length; i++) {
            setsLine[i] = new HashSet<Integer>();
        }
        Set[] setsRow = new Set[5];
        for (int i = 0; i < setsLine.length; i++) {
            setsRow[i] = new HashSet<Integer>();
        }
        dfs(0, result, flag, setsLine, setsRow);
    }

    @SuppressWarnings("unchecked")
    private static void dfs(int count, int[][] result, int[][] flag, Set[] setsLine, Set[] setsRow) {
        if (count > 24) {
            for (int[] ints : result) {
                for (int j = 0; j < result.length; j++) {
                    System.out.print(ints[j] + " ");
                }
                System.out.print("\n");
            }
            System.out.println("_--------------------__");
            return;
        }

        int a = count / 5;
        int b = count % 5;

        for (int num = 1; num <= 5; num++) {
            if (flag[a][b] == 0) {
                if (setsLine[a].contains(num) || setsRow[b].contains(num)) {
                    continue;
                }
                flag[a][b] = 1;
                result[a][b] = num;
                setsLine[a].add(num);
                setsRow[b].add(num);
                dfs(count + 1, result, flag, setsLine, setsRow);
                setsLine[a].remove(num);
                setsRow[b].remove(num);
                flag[a][b] = 0;
            }
        }
    }
}
