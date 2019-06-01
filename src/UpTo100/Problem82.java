package UpTo100;

import utils.LinkedList;
import utils.ListNode;

public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode target, p, q;
        p = head;
        if (p.next != null && p.val == p.next.val) {
            while (p.next != null && p.val == p.next.val) {
                p = p.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Problem82 p = new Problem82();
        int[] a = {1,1};
        LinkedList l = new LinkedList(a);
        System.out.println(p.deleteDuplicates(l.head));
    }
}
