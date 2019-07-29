package UpTo150;

import utils.ListNode;

public class Problem141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            if (fast == slow) return true;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return false;
            }
            if (fast == slow) return true;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return false;
            }
            slow = slow.next;
        }
        return false;
    }
}
