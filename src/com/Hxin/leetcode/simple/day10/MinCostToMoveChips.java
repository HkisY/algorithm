package com.Hxin.leetcode.simple.day10;

/**
 * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
 * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：position = [1,2,3]
 * 输出：1
 * 解释：第一步:将位置3的筹码移动到位置1，成本为0。
 * 第二步:将位置2的筹码移动到位置1，成本= 1。
 * 总成本是1。
 * <p>
 * 示例 2：
 * <p>
 * 输入：position = [2,2,2,3,3]
 * 输出：2
 * 解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
 * <p>
 * 示例 3:
 * <p>
 * 输入：position = [1,1000000000]
 * 输出：1
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/10 21:36
 */
public class MinCostToMoveChips {
    public static void main(String[] args) {

    }

    public static int minCostToMoveChips(int[] position) {
        int oddNum = 0, evenNum = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                evenNum++;
            } else oddNum++;
        }
        return Math.min(oddNum, evenNum);
    }
}
