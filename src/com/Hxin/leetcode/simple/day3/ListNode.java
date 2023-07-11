package com.Hxin.leetcode.simple.day3;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/5/4 23:11
 */
public class ListNode {
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
