package com.Hxin.leetcode.middle.month2.day3;

import com.Hxin.leetcode.middle.month2.day2.Merge;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * <p>
 * 输出：[[1,5],[6,9]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * <p>
 * 输出：[[1,2],[3,10],[12,16]]
 * <p>
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * <p>
 * 输出：[[5,7]]
 * <p>
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * <p>
 * 输出：[[1,5]]
 * <p>
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * <p>
 * 输出：[[1,7]]
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/8/28  21:01
 */
public class Insert {
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] temp = new int[intervals.length+1][];
        System.arraycopy(intervals, 0, temp, 0, intervals.length);
        temp[intervals.length] = newInterval;
        return Merge.merge(temp);
    }
}
