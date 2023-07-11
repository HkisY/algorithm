package com.Hxin.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO:未成功
 * @author Hxin
 * @version 1.0
 * @since 2022/10/19
 */
public class CoinChange {
    private static int FINAL_RESULT = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
//        int result = coinChange(coins,amount);
        System.out.println(coinChange(coins, amount));

    }

    public static int coinChange(int[] coins, int amount, int leftCoinNum) {
        if (amount == 0) {
            return leftCoinNum;
        }
        int resultNum = leftCoinNum;
        int repeatCoinNum = 0;
        int coinIndex = coins.length - 1;
        //函数外部排序
        Arrays.sort(coins);
        //最大硬币面值重复数量
        int tempCoinNum = amount / coins[coinIndex];
        while (coinIndex >= 0) {
            repeatCoinNum = amount / coins[coinIndex];
            amount -= coins[coinIndex] * repeatCoinNum;
            resultNum += repeatCoinNum;
            coinIndex -= 1;
        }
        if (coins.length == 1 && amount != 0) {
            return -1;
        }
        for (int i = 1; i <= repeatCoinNum; i++) {
            coinChange(Arrays.copyOf(coins, coins.length - 1), amount - (tempCoinNum - i) * coins[coins.length - 1], tempCoinNum - i);
        }
        return resultNum;
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        if (FINAL_RESULT == Integer.MAX_VALUE){
            return -1;
        }else {
            return FINAL_RESULT;
        }
    }

    public static void dfs(int[] coins, int index, int amount, int leftCoinNum) {
        if (index < 0) {
            return;
        }
        for (int coinNum = amount / coins[index]; coinNum >= 0; coinNum--) {
            int leftAmount = amount - coinNum * coins[index];
            int resultNum = leftCoinNum + coinNum;
            if (leftAmount == 0) {
                FINAL_RESULT = Math.min(FINAL_RESULT, resultNum);
                break;
            }
            if (resultNum + 1 >= FINAL_RESULT) {
                break;
            }
            dfs(coins, index - 1, leftAmount, resultNum);
        }
    }

    static class MyCompare implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }
}
