package UpTo100;

import utils.LinkedList;
import utils.ListNode;

public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        ListNode q = p.next, front = q.next;
        for (int i = 0; i < n - m; i++) {
            q.next = front.next;
            front.next = p.next;
            p.next = front;
            front = q.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Problem92 p = new Problem92();
        int[] a = {1,2,3,4,5};
        LinkedList l = new LinkedList(a);
        System.out.println(p.reverseBetween(l.head,1,5));
    }
}
