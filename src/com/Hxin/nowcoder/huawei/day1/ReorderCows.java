package com.Hxin.nowcoder.huawei.day1;

/**
 * @Author HkisY
 * @Version 0.0.1
 * @Date 2023/9/20  18:41
 */
public class ReorderCows {
    public ListNode reorderCows(ListNode head) {
        boolean flag = true;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode oddP = odd;
        ListNode evenP = even;

        while (head.next!=null){
            if (flag){
                odd.next = new ListNode(head.val);
                odd = odd.next;
                head = head.next;
                flag = false;
            }else {
                even.next = new ListNode(head.val);
                even = even.next;
                head = head.next;
                flag = true;
            }
        }
        if (flag){
            odd.next = new ListNode(head.val);
            odd = odd.next;
            head = head.next;
            flag = false;
        }else {
            even.next = new ListNode(head.val);
            even = even.next;
            head = head.next;
            flag = true;
        }
        while (odd.next!=null){
            odd = odd.next;
        }
        odd.next = evenP.next;
        // write code here
        return oddP.next;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
