package com.Hxin.leetcode.simple.day16;

import java.util.Arrays;

/**
 * n 个朋友在玩游戏。这些朋友坐成一个圈，按 顺时针方向 从 1 到 n 编号。从第 i 个朋友的位置开始顺时针移动 1 步会到达第 (i + 1) 个朋友的位置
 * （1 <= i < n），而从第 n 个朋友的位置开始顺时针移动 1 步会回到第 1 个朋友的位置。
 * <p>
 * 游戏规则如下：
 * <p>
 * 第 1 个朋友接球。接着，第 1 个朋友将球传给距离他顺时针方向 k 步的朋友。
 * 然后，接球的朋友应该把球传给距离他顺时针方向 2 * k 步的朋友。
 * 接着，接球的朋友应该把球传给距离他顺时针方向 3 * k 步的朋友，以此类推。
 * 换句话说，在第 i 轮中持有球的那位朋友需要将球传递给距离他顺时针方向 i * k 步的朋友。
 * 当某个朋友第 2 次接到球时，游戏结束。
 * 在整场游戏中没有接到过球的朋友是 输家 。
 * <p>
 * 给你参与游戏的朋友数量 n 和一个整数 k ，请按升序排列返回包含所有输家编号的数组 answer 作为答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, k = 2
 * <p>
 * 输出：[4,5]
 * <p>
 * 解释：以下为游戏进行情况：
 * <p>
 * 1）第 1 个朋友接球，第 1 个朋友将球传给距离他顺时针方向 2 步的玩家 —— 第 3 个朋友。
 * <p>
 * 2）第 3 个朋友将球传给距离他顺时针方向 4 步的玩家 —— 第 2 个朋友。
 * <p>
 * 3）第 2 个朋友将球传给距离他顺时针方向 6 步的玩家 —— 第 3 个朋友。
 * <p>
 * 4）第 3 个朋友接到两次球，游戏结束。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 4, k = 4
 * <p>
 * 输出：[2,3,4]
 * <p>
 * 解释：以下为游戏进行情况：
 * <p>
 * 1）第 1 个朋友接球，第 1 个朋友将球传给距离他顺时针方向 4 步的玩家 —— 第 1 个朋友。
 * <p>
 * 2）第 1 个朋友接到两次球，游戏结束。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/16 17:07
 */
public class CircularGameLosers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularGameLosers(4, 4)));
    }

    public static int[] circularGameLosers(int n, int k) {
        int[] flags = new int[n];
        //初始化
        int startPos = 0, index = 1;
        flags[startPos] = 1;
        int ansNum = 1;
        while (true) {
            startPos = (startPos + index * k) % n;
            if (flags[startPos] == 1) {
                break;
            } else {
                ansNum++;
                flags[startPos] = 1;
                index++;
            }
        }
        int[] res = new int[n - ansNum];
        for (int i = 0, j = 0; i < flags.length; i++) {
            if (flags[i] == 0) {
                res[j] = i + 1;
                j++;
            }
        }


//        List<Integer> ans = new ArrayList<>();
//        for (int i = 0; i < flags.length; i++) {
//            if (flags[i] == 0) {
//                ans.add(i + 1);
//            }
//        }
//
//        int[] res = new int[ans.size()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = ans.get(i);
//        }
        return res;
    }
}
