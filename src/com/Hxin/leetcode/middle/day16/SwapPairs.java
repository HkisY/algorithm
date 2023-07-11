package com.Hxin.leetcode.middle.day16;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 链接：https://leetcode.cn/problems/swap-nodes-in-pairs
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/6/20 21:40-23:29
 */
public class SwapPairs {
    public static void main(String[] args) {
//        ListNode node6 = new ListNode(6);
//        ListNode node5 = new ListNode(5, node6);
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        System.out.println(swapPairs(node1));
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        boolean isFirst = true;
        ListNode finalHead = new ListNode();
        ListNode pointNode = new ListNode();
        while (head != null && head.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = head;
            head = temp;
            if (isFirst) {
                finalHead = head;
                isFirst = false;
                pointNode = finalHead;
            } else {
                pointNode = pointNode.next;
                pointNode.next = head;
                pointNode = pointNode.next;
            }
            head = head.next.next;
        }
        return finalHead;
    }
}
