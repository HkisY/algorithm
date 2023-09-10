package com.Hxin.offerTest.bilibili;

import java.util.Arrays;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/9 19:39
 */
public class Test2 {
    public static void main(String[] args) {

    }

    public int subSetNum(int[] nums, int k) {
        // write code here
        Arrays.sort(nums);
//        flags 表示 i j 号元素不符合题意
        int[][] flags = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[j] - nums[i]) == k) {
                    flags[i][j] = 1;
                }
            }
        }
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int[] tempFlag = new int[nums.length];
            for (int j = i + 1; j < nums.length; j++) {
                if (flags[i][j] != 1) {
                    tempFlag[j] = 1;
                    ans++;
                }
            }
            for (int j = 0; j < tempFlag.length; j++) {
                for (int l = 0; l < tempFlag.length; l++) {
                    if (tempFlag[j] == 1 && tempFlag[l] == 1){
                        if (flags[j][l] == 1) {
                            ans--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
