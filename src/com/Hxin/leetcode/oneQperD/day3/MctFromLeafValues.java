package com.Hxin.leetcode.oneQperD.day3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个正整数数组arr，考虑所有满足以下条件的二叉树：
 * 每个节点都有 0 个或是 2 个子节点。
 * 数组arr中的值与树的中序遍历中每个叶节点的值一一对应。
 * 每个非叶节点的值等于其左子树和右子树中叶节点的最大值的乘积。
 * 在所有这样的二叉树中，返回每个非叶节点的值的最小可能总和。这个和的值是一个32 位整数。
 * <p>
 * 如果一个节点有 0 个子节点，那么该节点为叶节点。
 * <p>
 * 示例 1：
 * 24                   24
 * 12     4            6       8
 * 6    2                     2    4
 * 输入：arr = [6,2,4]
 * 输出：32
 * 解释：有两种可能的树，第一种的非叶节点的总和为 36 ，第二种非叶节点的总和为 32 。
 * <p>
 * 示例 2：
 * 44
 * 4       11
 * <p>
 * 输入：arr = [4,11]
 * 输出：44
 * <p>
 * 链接：https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/31 22:17
 */
public class MctFromLeafValues {
    private static int mctFromLeafValues(int[] arr) {
        int res = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        for (int x : arr) {
            while (!stk.isEmpty() && stk.peek() <= x) {
                int y = stk.pop();
                if (stk.isEmpty() || stk.peek() > x) {
                    res += y * x;
                } else {
                    res += stk.peek() * y;
                }
            }
            stk.push(x);
        }
        while (stk.size() >= 2) {
            int x = stk.pop();
            res += stk.peek() * x;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 4};
        System.out.println(mctFromLeafValues(arr));

    }
}
