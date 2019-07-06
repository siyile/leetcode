package UpTo100;

import utils.LinkedList;
import utils.ListNode;

public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;
        int prev = 0;
        boolean change = false;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                prev = p.next.val;
            }
            while (p.next != null && p.next.val == prev) {
                p.next = p.next.next;
                change = true;
            }
            if (!change) {
                p = p.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Problem82 p = new Problem82();
        int[] a = {1,1};
        LinkedList l = new LinkedList(a);
        System.out.println(p.deleteDuplicates(l.head));
    }
}
