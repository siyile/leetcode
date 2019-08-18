package UpTo100;

import utils.LinkedList;
import utils.ListNode;

public class Problem61 {
    public static void main(String[] args) {
        Problem61 p = new Problem61();
        int[] a = {1, 2, 3, 4, 5};
        LinkedList l = new LinkedList(a);
        System.out.println(p.rotateRight(l.head, 1));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int n = 1;
        ListNode p = head;
        while (p.next != null) {
            n++;
            p = p.next;
        }
        p.next = head;
        for (int i = 0; i < n - k % n; i++) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
