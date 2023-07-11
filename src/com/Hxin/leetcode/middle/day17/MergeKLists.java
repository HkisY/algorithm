package com.Hxin.leetcode.middle.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
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
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/6/22 15:59
 */
public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tempNode = head;
        ArrayList<Integer> numList = new ArrayList<>();
        for (ListNode list : lists) {
            while (list != null) {
                numList.add(list.val);
                list=list.next;
            }
        }
        Collections.sort(numList);
        for (Integer i : numList) {
            head.next = new ListNode(i);
            head = head.next;
        }
        return tempNode.next;
    }

    public static void main(String[] args) {
        ListNode node3 = new ListNode(5);
        ListNode node2 = new ListNode(4,node3);
        ListNode node1 = new ListNode(1,node2);


        ListNode node13 = new ListNode(4);
        ListNode node12 = new ListNode(3,node13);
        ListNode node11 = new ListNode(1,node12);


        ListNode node22 = new ListNode(6);
        ListNode node21 = new ListNode(2,node22);

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = node1;
        listNodes[1] = node11;
        listNodes[2] = node21;

        System.out.println(mergeKLists(listNodes).toString());

    }
}
