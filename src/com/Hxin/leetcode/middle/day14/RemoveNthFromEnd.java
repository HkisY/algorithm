package com.Hxin.leetcode.middle.day14;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/29 20:38-21:10
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
//        ListNode num5 = new ListNode(5);
//        ListNode num4 = new ListNode(4, num5);
//        ListNode num3 = new ListNode(3, num4);
        ListNode num2 = new ListNode(2);
        ListNode num1 = new ListNode(1, num2);
        System.out.println(removeNthFromEnd(num1, 2).toString());

    }

    /**
     * @param head headNode
     * @param n    (head.size()-n)th node
     * @return ListNode
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempNode = head;
        ListNode result = tempNode;
        int size = 1;
        while (head.next != null) {
            head = head.next;
            size++;
        }
        if (size == 1) {
            return null;
        }
        if (size == n){
            return result.next;
        }
        for (int i = 0; i < size - n - 1; i++) {
            tempNode = tempNode.next;
        }

        tempNode.next = tempNode.next.next;
        return result;
    }
}
