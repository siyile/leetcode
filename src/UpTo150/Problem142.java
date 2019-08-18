package UpTo150;

import utils.ListNode;

public class Problem142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q)
                break;
        }
        if (q == null || q.next == null) return null;
        q = head;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
