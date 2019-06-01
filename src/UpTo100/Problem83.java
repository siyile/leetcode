package UpTo100;

import utils.LinkedList;
import utils.ListNode;

public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p, q;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        p = dummy;
        while (p.next != null) {
            q = p;
            p = p.next;
            while (p.next != null && p.val == p.next.val) {
                p = p.next;
            }
            q.next = p;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Problem83 p = new Problem83();
        int[] a = {1,1};
        LinkedList l = new LinkedList(a);
        System.out.println(p.deleteDuplicates(l.head));
    }
}
