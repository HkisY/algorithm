package com.Hxin.algorithm.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hxin
 * @version 1.0
 * @since 2022/4/24
 */
public class MatrixSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();
        while (sc.hasNextLine()) {
            if (sc.hasNext("0")) {
                break;
            }
            input.add(Integer.parseInt(sc.nextLine()));
        }
        for (int i : input) {
            int[][] result = new int[i][i];
            result = solution(result, i, 1, true, 0, 0);
            for (int[] j : result) {
                for (int k : j) {
                    System.out.print(k + " ");
                }
                System.out.print("\n");
            }
        }
    }

    /**
     * @param a         result Array
     * @param n         rank num
     * @param batchFlag indicator
     * @param startNum  the matrix` start number
     * @return int[][]
     */
    private static int[][] solution(int[][] a, int n, int startNum, boolean batchFlag, int startFlag, int loopTime) {
        if (n == 0) {
            return a;
        }
        if (batchFlag) {//偶数旋转 从左上到右下
            batchFlag = false;
            int tempLineTag = startFlag, tempRowTag = startFlag;
            while (a[a.length - 1 - loopTime][a.length - 1 - loopTime] == 0) {
                if (tempRowTag == a.length - loopTime) {
                    a[tempLineTag + 1][tempRowTag - 1] = startNum++;
                    tempLineTag++;
                } else {
                    a[tempLineTag][tempRowTag] = startNum++;
                    tempRowTag++;
                }
            }
            startFlag = tempLineTag;
        } else {//奇数从右下到左上
            batchFlag = true;
            int tempLineTag = startFlag, tempRowTag = startFlag - 1;
            while (a[loopTime + 1][loopTime] == 0) {
                if (tempRowTag == loopTime) {
                    a[tempLineTag][tempRowTag] = startNum++;
                    tempLineTag--;
                } else {
                    a[tempLineTag][tempRowTag] = startNum++;
                    tempRowTag--;
                }
            }
            startFlag = tempLineTag + 1;
            loopTime++;
        }
        return solution(a, n - 1, startNum, batchFlag, startFlag, loopTime);
    }
}
