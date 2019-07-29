package UpTo150;

import utils.ListNode;

public class Problem143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // step 1: find the middle
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // step 2: reverse later half
        ListNode preMiddle = slow;
        ListNode cur = slow.next;
        while (cur.next != null) {
            ListNode tail = cur.next;
            cur.next = tail.next;
            tail.next = preMiddle.next;
            preMiddle.next = tail;
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        cur = head;
        // step 3: reorder
        while (preMiddle != cur) {
            ListNode node = preMiddle.next;
            preMiddle.next = node.next;
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
    }
}
