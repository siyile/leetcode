package Upto250;

import utils.ListNode;

public class Problem234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode p = head, q = p;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        p.next = reverse(p.next);
        q = head;
        p = p.next;
        while (p != null && q != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
