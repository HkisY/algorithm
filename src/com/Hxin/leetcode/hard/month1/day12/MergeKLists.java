package com.Hxin.leetcode.hard.month1.day12;

import java.util.ArrayList;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/8/12 12:15
 */
public class MergeKLists {
    public static void main(String[] args) {
//        ListNode list13 = new ListNode(5);
//        ListNode list12 = new ListNode(4, list13);
//        ListNode list11 = new ListNode(1, list12);
//
//        ListNode list23 = new ListNode(4);
//        ListNode list22 = new ListNode(3, list23);
//        ListNode list21 = new ListNode(1, list22);
//        ListNode[] lists = new ListNode[2];
//        lists[0] = list11;
//        lists[1] = list21;
//
        ListNode list1 = new ListNode(1);
        ListNode[] lists = new ListNode[1];
        lists[0] = list1;
        System.out.println(mergeKLists(lists));
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            while (true) {
                arrayList.add(list.val);
                if (list.next == null) {
                    break;
                }
                list = list.next;
            }
        }
        arrayList.sort((o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            } else if (o1 >= o2) {
                return 1;
            } else {
                return -1;
            }
        });
        ListNode tempRes = new ListNode();
        res.next = tempRes;
        for (Integer integer : arrayList) {
            tempRes.next = new ListNode(integer);
            tempRes = tempRes.next;
        }
        return res.next.next;
    }

    public static ListNode mergeKListsByHeap(ListNode[] lists) {
        return null;
    }

    private static class MinHeap {

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
