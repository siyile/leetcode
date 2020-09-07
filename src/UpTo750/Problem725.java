package UpTo750;

import utils.ListNode;

public class Problem725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode p = root;
        while (p != null) {
            n++;
            p = p.next;
        }
        int num = n / k;
        int m = n - num * k;
        p = root;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < m; i++) {
            res[i] = p;
            p = split(p, num + 1);
        }
        for (int i = m; i < n; i++) {
            res[i] = p;
            p = split(p, num);
        }
        return res;
    }

    public ListNode split(ListNode head, int num) {
        if (head == null) return null;
        ListNode p = head;
        for (int i = 0; i < num - 1; i++) {
            p = p.next;
        }
        ListNode right = p.next;
        p.next = null;
        return right;
    }
}
