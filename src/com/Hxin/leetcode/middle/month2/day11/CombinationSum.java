package com.Hxin.leetcode.middle.month2.day11;

import java.util.*;

/**
 * 39
 *
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/22  15:29
 */
public class CombinationSum {
    private static List<List<Integer>> ans = new ArrayList<>();
    private static Set<String> containCheck = new HashSet<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tempList = new ArrayList<>();
        dfs(0, 0, target, tempList, candidates);
        return ans;
    }

    private static void dfs(int count, int sum, int target, List<Integer> tempList, int[] candidates) {
        if (sum == target) {
            List<Integer> ansList = new ArrayList<>(tempList);
            Collections.sort(ansList);
            StringBuilder sb = new StringBuilder();
            for (Integer integer : ansList) {
                sb.append(integer);
            }
            if (containCheck.isEmpty()){
                containCheck.add(sb.toString());
                ans.add(ansList);
            }else {
                if (!containCheck.contains(sb.toString())) {
                    containCheck.add(sb.toString());
                    ans.add(ansList);
                }
            }
            return;

        }
        if (sum > target) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            sum += candidates[i];
            tempList.add(candidates[i]);
            dfs(count + 1, sum, target, tempList, candidates);
            tempList.remove(tempList.size() - 1);
            sum -= candidates[i];
        }
    }
}
