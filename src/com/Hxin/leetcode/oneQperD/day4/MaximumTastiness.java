package com.Hxin.leetcode.oneQperD.day4;

import java.util.Arrays;

/**
 * 给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
 * 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
 * 返回礼盒的 最大 甜蜜度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：price = [13,5,1,8,21,2], k = 3
 * 输出：8
 * 解释：选出价格分别为 [13,5,21] 的三类糖果。
 * 礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
 * 可以证明能够取得的最大甜蜜度就是 8 。
 * <p>
 * 示例 2：
 * 输入：price = [1,3,1], k = 2
 * 输出：2
 * 解释：选出价格分别为 [1,3] 的两类糖果。
 * 礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
 * 可以证明能够取得的最大甜蜜度就是 2 。
 * <p>
 * 示例 3：
 * 输入：price = [7,7,7,7], k = 2
 * 输出：0
 * 解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
 * <p>
 * 链接：https://leetcode.cn/problems/maximum-tastiness-of-candy-basket
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/6/1 21:24
 */
public class MaximumTastiness {

    public static void main(String[] args) {
//        int[] price = {13, 5, 1, 8, 21, 2};
        int[] price = {1, 3, 1};
        int k = 2;
        System.out.println(maximumTastiness(price, k));
    }

    private static int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int rightPoint = price[price.length - 1] - price[0], leftPoint = 0;
        while (rightPoint - leftPoint > 1) {
            int middle = leftPoint + (rightPoint - leftPoint) / 2;
            if (findNumOfCandy(middle, price, k)) {
                leftPoint = middle;
            } else {
                rightPoint = middle;
            }
        }
        //进行一次向前试探
        if (findNumOfCandy(leftPoint + 1 + (rightPoint - leftPoint) / 2, price, k)) {
            return leftPoint + 1 + (rightPoint - leftPoint) / 2;
        }
        return leftPoint + (rightPoint - leftPoint) / 2;
    }

    private static boolean findNumOfCandy(int targetNum, int[] price, int num) {
        int calculator = 1;
        int tempPrice = price[0];
        for (int i = 1; i < price.length; i++) {
            if (calculator < num) {
                if (price[i] - tempPrice >= targetNum) {
                    tempPrice = price[i];
                    calculator++;
                }
            } else {
                return true;
            }
        }
        return calculator == num;
    }


    public int maximumTastinessWay(int[] price, int k) {
        Arrays.sort(price);
        int left = 0, right = price[price.length - 1] - price[0];
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(price, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean check(int[] price, int k, int tastiness) {
        int prev = Integer.MIN_VALUE / 2;
        int cnt = 0;
        for (int p : price) {
            if (p - prev >= tastiness) {
                cnt++;
                prev = p;
            }
        }
        return cnt >= k;
    }
}
