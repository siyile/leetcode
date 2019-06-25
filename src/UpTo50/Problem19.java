package UpTo50;

import utils.ListNode;

public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast, slow;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        slow = dummy;
        fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
