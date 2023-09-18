package com.Hxin.offerTest.tencent2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Hxin
 * @version 1.0
 * @since 2023/9/15 20:00
 */
public class Test1 {
    public static void main(String[] args) {


    }

    public ListNode solve(ListNode[] a) {
        if (a.length == 0){
            return null;
        }
        // write code here
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            while (a[i].next != null) {
                numList.add(a[i].val);
                a[i] = a[i].next;
            }
            numList.add(a[i].val);
        }
        numList.sort(Comparator.comparingInt(o -> o));
        ListNode root = new ListNode(numList.get(0));
        ListNode temp = root;
        for (int i = 1; i < numList.size(); i++) {
            ListNode node = new ListNode(numList.get(i));
            temp.next = node;
            temp = node;
        }
        return root;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
