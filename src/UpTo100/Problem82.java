package UpTo100;

import utils.LinkedList;
import utils.ListNode;

public class Problem82 {
    public static void main(String[] args) {
        Problem82 p = new Problem82();
        int[] a = {1, 1, 2, 3, 3, 3, 4, 4};
        LinkedList l = new LinkedList(a);
        System.out.println(p.deleteDuplicates(l.head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode q = p.next.next;
            if (q.val == p.next.val) {
                while (q != null && q.val == p.next.val) {
                    q = q.next;
                }
                p.next = q;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
}
