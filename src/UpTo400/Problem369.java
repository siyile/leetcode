package UpTo400;

import utils.ListNode;

public class Problem369 {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNot9 = dummy, node = head;
        while (node != null) {
            if (node.val != 9) {
                lastNot9 = node;
            }
            node = node.next;
        }

        lastNot9.val += 1;
        node = lastNot9.next;
        while (node != null) {
            node.val = 0;
            node = node.next;
        }

        return dummy.val == 1 ? dummy : dummy.next;
    }
}
