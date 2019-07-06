package UpTo50;

import utils.ListNode;

public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            p.next = new ListNode((a + b + carry) % 10);
            p = p.next;
            carry = (a + b) / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            p.next = new ListNode(1);
        }
        return dummy.next;
    }
}
