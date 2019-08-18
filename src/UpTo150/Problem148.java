package UpTo150;

import utils.LinkedList;
import utils.ListNode;

public class Problem148 {
    public static void main(String[] args) {
        Problem148 p = new Problem148();
        LinkedList t = new LinkedList(new int[]{1, -1, 2});
        System.out.println(p.sortList(t.head));
    }

    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // get length
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }

        ListNode prev;
        for (int step = 1; step < n; step <<= 1) {
            prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step);
                prev = merge(left, right, prev);
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode left, int step) {
        if (left == null) return null;
        ListNode p = left;
        for (int i = 1; i < step && p.next != null; i++) {
            p = p.next;
        }
        ListNode right = p.next;
        p.next = null;
        return right;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode p = prev;
        while (left != null && right != null) {
            if (left.val > right.val) {
                p.next = right;
                right = right.next;
            } else {
                p.next = left;
                left = left.next;
            }
            p = p.next;
        }
        if (left == null) p.next = right;
        else p.next = left;
        while (p.next != null) p = p.next;
        // return prev node
        return p;
    }
}
