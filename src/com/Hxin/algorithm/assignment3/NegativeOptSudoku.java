package com.Hxin.algorithm.assignment3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/5/24
 */
public class NegativeOptSudoku {
//    public static void main(String[] args) {
//        int[][] sourceAfter = {
//                {3, 0, 6, 5, 0, 8, 4, 0, 0},
//                {5, 2, 0, 0, 0, 0, 0, 0, 0},
//                {0, 8, 7, 0, 0, 0, 0, 3, 1},
//                {0, 0, 3, 0, 1, 0, 0, 8, 0},
//                {9, 0, 0, 8, 6, 3, 0, 0, 5},
//                {0, 5, 0, 0, 9, 0, 6, 0, 0},
//                {1, 3, 0, 0, 0, 0, 2, 5, 0},
//                {0, 0, 0, 0, 0, 0, 0, 7, 4},
//                {0, 0, 5, 2, 0, 6, 3, 0, 0}
//        };
//        int[][] flagAfter = new int[9][9];
//        long startAfterOpt = System.currentTimeMillis();
//
//        //行检测器
//        Set[] setsLine = new Set[9];
//        for (int i = 0; i < 9; i++) {
//            setsLine[i] = new HashSet<Integer>();
//        }
//        //列检测器
//        Set[] setsRow = new Set[9];
//        for (int i = 0; i < 9; i++) {
//            setsRow[i] = new HashSet<Integer>();
//        }
//        markLineRowSets(sourceAfter, setsLine, setsRow);
//        markFlag(sourceAfter, flagAfter);
//        dfs(0, sourceAfter, flagAfter, setsLine, setsRow);
//        long endAfterOpt = System.currentTimeMillis();
//        System.out.println("After opt, all the time is " + (endAfterOpt - startAfterOpt) + " ms");
//    }
//
//    private static void dfs(int count, int[][] source, int[][] flag, Set[] setsLine, Set[] setsRow) {
//        if (count > 80) {
//            for (int[] i : source) {
//                for (int j : i) {
//                    System.out.print(j + " ");
//                }
//                System.out.print("\n");
//            }
//            System.out.println("---------------");
//            return;
//        }
//        int lineNum = count / 9;    //line num
//        int rowNum = count % 9;    //row num
//        if (flag[lineNum][rowNum] == 0) {
//            for (int i = 1; i < 10; i++) {
//                if (checked(i, source, lineNum, rowNum, setsLine, setsRow)) {
//                    flag[lineNum][rowNum] = 1;
//                    source[lineNum][rowNum] = i;
//                    setsLine[lineNum].add(i);
//                    setsRow[rowNum].add(i);
//                    dfs(count + 1, source, flag, setsLine, setsRow);
//                    setsLine[lineNum].remove(i);
//                    setsRow[rowNum].remove(i);
//                    flag[lineNum][rowNum] = 0;
//                    source[lineNum][rowNum] = 0;
//                }
//            }
//        } else {
//            dfs(count + 1, source, flag, setsLine, setsRow);
//        }
//    }
//
//    private static boolean checked(int targetNum, int[][] source, int lineNum, int rowNum, Set[] setsLine, Set[] setsRow) {
//        //check line
//        if (setsLine[lineNum].contains(targetNum)) return false;
//        //check row
//        if (setsRow[rowNum].contains(targetNum)) return false;
//        //check rectangle
//        int tempLine = lineNum / 3;
//        int tempRow = rowNum / 3;
//        for (int i = tempLine * 3; i < tempLine + 3; i++) {
//            for (int j = tempRow * 3; j < tempRow + 3; j++) {
//                if (targetNum == source[i][j]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    @SuppressWarnings("unchecked")
//    private static void markLineRowSets(int[][] source, Set[] setsLine, Set[] setsRow) {
//        for (int i = 0; i < source.length; i++) {
//            for (int j = 0; j < source.length; j++) {
//                int temp = source[i][j];
//                if (temp != 0) {
//                    setsLine[i].add(temp);
//                    setsRow[j].add(temp);
//                }
//            }
//        }
//    }
//
//    private static void markFlag(int[][] source, int[][] flag) {
//        for (int i = 0; i < source.length; i++) {
//            for (int j = 0; j < source[i].length; j++) {
//                if (source[i][j] != 0) {
//                    flag[i][j] = 2;
//                }
//            }
//        }
//    }
}
