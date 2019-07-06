package UpTo50;

import utils.LinkedList;
import utils.ListNode;

public class Problem24 {
    public ListNode swapPairs2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q, r, s;
        head = head.next;
        q = head;
        while (true) {
            if (q.next != null) r = q.next;
            else {
                p.next = null;
                q.next = p;
                return head;
            }
            if (r.next != null) s = r.next;
            else {
                p.next = r;
                q.next = p;
                return head;
            }
            p.next = s;
            q.next = p;

            p = r;
            q = s;
        }
    }

    public ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy, q;
        ListNode prev;
        while (p.next != null && p.next.next != null) {
            prev = p;
            p = p.next;
            q = p.next;
            prev.next = q;
            p.next = q.next;
            q.next = p;
        }
        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head, q = head.next;
        p.next = swapPairs(q.next);
        q.next = p;
        return q;
    }

    public static void main(String[] args) {
        Problem24 p = new Problem24();
        int [] a = {};
        LinkedList l1 = new LinkedList(a);
        System.out.println(p.swapPairs(l1.head));
    }
}
