package com.Hxin.leetcode.middle.day5;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 链接：https://leetcode.cn/problems/add-two-numbers
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/14 16:46-17:45
 */
public class AddTwoNumbers {
    /**
     * 常规方法
     *
     * @param l1 l1
     * @param l2 l2
     * @return ListNode
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        while (true) {
            l1.val = l1.val + l2.val;
            if (l1.next == null && l2.next == null) {
                break;
            }
            // 不处理进位直接相加 处理节点下移
            if (l1.next == null) {
                l1.next = l2.next;
                break;
            } else if (l2.next == null) {
                break;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        ListNode result = temp;
        while (true) {
            if (temp.next == null) {
                if (temp.val >= 10) {
                    ListNode tempNode = new ListNode(1);
                    temp.val = temp.val - 10;
                    temp.next = tempNode;
                }
                break;
            }
            if (temp.val >= 10) {
                temp.val = temp.val - 10;
                temp.next.val += 1;
            }
            temp = temp.next;
        }
        return result;
    }

    /**
     * TODO:返回值不是头结点
     * 递归代码逻辑结果均正确，但是返回值不是头结点
     * @param l1 l1
     * @param l2 l2
     * @return ListNode
     */
    private static ListNode addTwoNumbersWay(ListNode l1, ListNode l2) {
        if (l1.next == null && l2.next == null) {
            l1.val = l1.val + l2.val;
            if (l1.val >= 10) {
                l1.val -= 10;
                l1.next = new ListNode(1);
            }
            return l1;
        }
        ListNode zeroNode = new ListNode(0);
        if (l1.next == null) {
            l1.next = zeroNode;
        } else if (l2.next == null) {
            l2.next = zeroNode;
        }

        // 处理进位
        l1.val = l1.val + l2.val;
        if (l1.val >= 10) {
            l1.val -= 10;
            l1.next.val += 1;
        }
        return addTwoNumbersWay(l1.next, l2.next);
    }

    public static void main(String[] args) {
        ListNode b = new ListNode(3);
        ListNode a = new ListNode(4, b);
        ListNode l1 = new ListNode(2, a);

        ListNode c = new ListNode(4);
        ListNode d = new ListNode(6, c);
        ListNode e = new ListNode(9, d);
        ListNode f = new ListNode(9, e);
        ListNode l2 = new ListNode(5, f);
        System.out.println(addTwoNumbersWay(l1, l2));
    }
}
