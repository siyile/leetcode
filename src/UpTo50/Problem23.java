package UpTo50;

import utils.LinkedList;
import utils.ListNode;

public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        for (int i = 1; i < n; i <<= 1) {
            for (int j = 0; j + i < n; j += 2 * i) {
                lists[j] = merge(lists[j], lists[j + i]);
            }
        }
        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Problem23 p = new Problem23();
        int[] a = {1, 5, 6};
        int[] b = {6, 6};
        int[] c = {2, 4, 9};
        LinkedList l1 = new LinkedList(a);
        LinkedList l2 = new LinkedList(b);
        LinkedList l3 = new LinkedList(c);
        System.out.println(p.mergeKLists(new ListNode[]{l1.head, l2.head, l3.head}));
    }
}

