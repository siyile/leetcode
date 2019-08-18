package UpTo150;

import utils.ListNode;

public class Problem143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        // find middle
        ListNode p = head, q = head;
        while (q.next != null && q.next.next != null) {
            q = q.next.next;
            p = p.next;
        }
        q = p.next;
        p.next = null;

        // reverse
        q = reverse(q);

        // insert
        p = head;
        while (q != null) {
            ListNode r = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
            q = r;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
