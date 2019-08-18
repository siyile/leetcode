package UpTo50;

import utils.LinkedList;
import utils.ListNode;

public class Problem25 {
    public static void main(String[] args) {
        Problem25 p = new Problem25();
        int[] a = {1, 2, 3, 4, 5};
        LinkedList l1 = new LinkedList(a);
        System.out.println(p.reverseKGroup(l1.head, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            ListNode tmp = p.next;
            for (int i = 0; i < k; i++) {
                if (tmp == null)
                    return dummy.next;
                else tmp = tmp.next;
            }
            ListNode front = p.next;
            ListNode q = front.next;
            for (int i = 0; i < k - 1 && q != null; i++) {
                front.next = q.next;
                q.next = p.next;
                p.next = q;
                q = front.next;
            }
            p = front;
        }
        return dummy.next;
    }
}
