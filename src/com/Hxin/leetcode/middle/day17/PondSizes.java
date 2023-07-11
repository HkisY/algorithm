package com.Hxin.leetcode.middle.day17;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。
 * 池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 输入：
 * [
 * [0,2,1,0],
 * [0,1,0,1],
 * [1,1,0,1],
 * [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * <p>
 * 链接：https://leetcode.cn/problems/pond-sizes-lcci
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/6/22 14:19-15：40
 */
public class PondSizes {
    public static void main(String[] args) {
        int[][] input = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        int[] output = pondSizes(input);
        for (int j : output) {
            System.out.print(j + " ");
        }
    }

    public static int[] pondSizes(int[][] land) {
        final int length = land.length;
        final int height = land[0].length;
        int[][] isOccupied = new int[length][height];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                int num = findPondByOnePoint(land, isOccupied, i, j, 0);
                if (num != 0) {
                    result.add(num);
                }
            }
        }
        int[] ints = new int[result.size()];
        int index = 0;
        for (Integer integer : result) {
            ints[index++] = integer;
        }
        Arrays.sort(ints);
        return ints;
    }

    private static int findPondByOnePoint(int[][] land, int[][] isOccupied, int startPointX, int startPointY, int resultSize) {
        //out of index
        if (startPointX > land.length - 1 || startPointY > land[0].length - 1) {
            return resultSize;
        }
        if (startPointY < 0 || startPointX < 0) {
            return resultSize;
        }


        if (isOccupied[startPointX][startPointY] != 0 || land[startPointX][startPointY] != 0) {
            return resultSize;
        }

        isOccupied[startPointX][startPointY] = 1;
        resultSize++;
        //下
        resultSize = findPondByOnePoint(land, isOccupied, startPointX + 1, startPointY, resultSize);
        //斜右下
        resultSize = findPondByOnePoint(land, isOccupied, startPointX + 1, startPointY + 1, resultSize);
        //斜左下
        resultSize = findPondByOnePoint(land, isOccupied, startPointX + 1, startPointY - 1, resultSize);
        //右
        resultSize = findPondByOnePoint(land, isOccupied, startPointX, startPointY + 1, resultSize);
        //左
        resultSize = findPondByOnePoint(land, isOccupied, startPointX, startPointY - 1, resultSize);
        //斜左上
        resultSize = findPondByOnePoint(land, isOccupied, startPointX - 1, startPointY - 1, resultSize);
        //斜右上
        resultSize = findPondByOnePoint(land, isOccupied, startPointX - 1, startPointY + 1, resultSize);
        //上
        resultSize = findPondByOnePoint(land, isOccupied, startPointX - 1, startPointY, resultSize);
        return resultSize;
    }

}


