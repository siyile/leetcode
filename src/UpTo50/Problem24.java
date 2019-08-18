package UpTo50;

import utils.LinkedList;
import utils.ListNode;

public class Problem24 {
    public static void main(String[] args) {
        Problem24 p = new Problem24();
        int [] a = {};
        LinkedList l1 = new LinkedList(a);
        System.out.println(p.swapPairs1(l1.head));
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = swapPairs1(head.next.next);
        ListNode q = head.next;
        head.next.next = head;
        head.next = p;
        return q;
    }
}
