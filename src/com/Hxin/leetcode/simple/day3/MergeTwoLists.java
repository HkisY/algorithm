package com.Hxin.leetcode.simple.day3;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author Hxin
 * @version 1.0
 * @since 2023/5/4 23:07-00:13
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode smallList;
        ListNode largeList;
        if (list1.val <= list2.val) {
            smallList = list1;
            largeList = list2;
        } else {
            smallList = list2;
            largeList = list1;
        }
        ListNode finalResult = smallList;
        ListNode tempExchange = largeList;
        //largeList 最后一个节点是否被安全的加到最终结果上 true 表示没有
        boolean flag = true;
        while (largeList.next != null) {
            if (smallList.next != null) {
                if (smallList.next.val > tempExchange.val && smallList.val < tempExchange.val) {
                    largeList = largeList.next;
                    tempExchange.next = smallList.next;
                    smallList.next = tempExchange;
                    smallList = smallList.next;
                    tempExchange = largeList;
                } else if (smallList.next.val == tempExchange.val || smallList.val == tempExchange.val) {
                    largeList = largeList.next;
                    tempExchange.next = smallList.next;
                    smallList.next = tempExchange;
                    smallList = smallList.next;
                    tempExchange = largeList;
                } else {
                    smallList = smallList.next;
                }
            } else {
                smallList.next = largeList;
                flag = false;
                break;
            }
        }
        //处理起始大数字的List的最后一个节点
        while (flag) {
            if (smallList.next == null) {
                smallList.next = tempExchange;
                flag = false;
            } else if (smallList.val <= tempExchange.val && smallList.next.val >= tempExchange.val) {
                ListNode a = smallList.next;
                smallList.next = tempExchange;
                smallList.next.next = a;
                flag = false;
            } else if (smallList.val < tempExchange.val) {
                smallList = smallList.next;
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        ListNode num1 = new ListNode(-10);
        ListNode num2 = new ListNode(-10);
        ListNode num3 = new ListNode(-9);
        ListNode num4 = new ListNode(-4);
        ListNode num5 = new ListNode(1);
        ListNode num6 = new ListNode(6);
        ListNode num7 = new ListNode(6);
        ListNode numA = new ListNode(-7);
        num1.next = num2;
        num2.next = num3;
        num3.next = num4;
        num4.next = num5;
        num5.next = num6;
        num6.next = num7;
        ListNode result = mergeTwoLists(num1, numA);
        System.out.println(result.toString());

    }

    public ListNode mergeTwoListsWay(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = l1.val < l2.val ? l1 : l2;
        res.next = mergeTwoListsWay(res.next, l1.val >= l2.val ? l1 : l2);
        return res;
    }
}
