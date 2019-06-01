package UpTo100;

import utils.LinkedList;
import utils.ListNode;

public class Problem86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLow = new ListNode(0);
        ListNode dummyHigh = new ListNode(0);
        dummyLow.next = head;
        ListNode q = dummyHigh;
        ListNode p = dummyLow;
        while (p.next != null) {
            if (p.next.val >= x) {
                q.next = p.next;
                q = q.next;
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        q.next = null;
        p.next = dummyHigh.next;
        return dummyLow.next;
    }

    public static void main(String[] args) {
        Problem86 p = new Problem86();
        int[] a = {};
        LinkedList l = new LinkedList(a);
        System.out.println(p.partition(l.head, 3));
    }
}
