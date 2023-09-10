package com.Hxin.leetcode.simple.month1.day13;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，
 * 后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/13 12:01
 */
public class Merge {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 0, 0, 0};
        int[] b = {1, 2, 3};
        mergeWay(a, 3, b, 3);
        for (int j : a) {
            System.out.print(j + " ");
        }
    }

    public static void mergeWay(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int aIndex = 0, bIndex = 0;
        while (aIndex < m + n) {
            if (nums1[aIndex] > nums2[bIndex]) {
                System.arraycopy(nums1, aIndex, nums1, aIndex + 1, m - aIndex + bIndex);
                nums1[aIndex] = nums2[bIndex];
                bIndex++;
            }
            if (aIndex == m + bIndex - 1) {
                System.arraycopy(nums2, bIndex, nums1, aIndex + 1, n - bIndex);
                break;
            }
            if (bIndex == n) {
                break;
            }
            aIndex++;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            tempList.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            tempList.add(nums2[i]);
        }
        tempList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < m + n; i++) {
            nums1[i] = tempList.get(i);
        }
    }
}
