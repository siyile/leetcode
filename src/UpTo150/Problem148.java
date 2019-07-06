package UpTo150;

import utils.BinaryTree;
import utils.LinkedList;
import utils.ListNode;

public class Problem148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            len++;
            p = p.next;
        }

        ListNode firstTracker, secondTracker, firstHead, secondHead, prev, next;

        for (int i = 1; i < len; i <<= 1) {
            prev = dummy;
            while (prev.next != null) {
                firstHead = prev.next;
                firstTracker = prev;
                for (int j = 0; j < i && firstTracker.next != null; j++) {
                    firstTracker = firstTracker.next;
                }
                secondTracker = firstTracker;
                for (int j = 0; j < i && secondTracker.next != null; j++) {
                    secondTracker = secondTracker.next;
                }
                secondHead = firstTracker.next;
                next = secondTracker.next;
                secondTracker.next = null;
                firstTracker.next = null;

                // merge
                while (firstHead != null && secondHead != null) {
                    if (firstHead.val < secondHead.val) {
                        prev.next = firstHead;
                        firstHead = firstHead.next;
                    } else {
                        prev.next = secondHead;
                        secondHead = secondHead.next;
                    }
                    prev = prev.next;
                }
                if (firstHead == null) {
                    prev.next = secondHead;
                } else {
                    prev.next = firstHead;
                }
                while (prev.next != null) {
                    prev = prev.next;
                }
                prev.next = next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Problem148 p = new Problem148();
        LinkedList t = new LinkedList(new int[]{0,-1,4,2,3,1});
        System.out.println(p.sortList(t.head));
    }
}
