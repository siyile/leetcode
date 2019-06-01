package UpTo100;

import utils.LinkedList;
import utils.ListNode;

public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        ListNode q, r;
        q = p.next;
        ListNode s = q;
        for (int i = 0; i < n - m + 1; i++) {
            r = q.next;
            q.next = p.next;
            p.next = q;
            q = r;
        }
        s.next = q;
        return dummy.next;
    }

    public static void main(String[] args) {
        Problem92 p = new Problem92();
        int[] a = {1,2,3,4,5};
        LinkedList l = new LinkedList(a);
        System.out.println(p.reverseBetween(l.head,1,5));
    }
}
