package UpTo150;

import utils.ListNode;

public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null && head.next == null) return null;
        ListNode fast = head.next;
        ListNode slow = head;
        boolean cycle = true;
        if (fast == null) return null;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast) {
                cycle = false;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if (cycle) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
