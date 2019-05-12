package UpTo50;

import utils.LinkedList;
import utils.ListNode;

public class Problem25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res = dummy;
        ListNode start, end;
        ListNode [] result;
        while (true){
            result = reverseKNode(dummy, k);
            start = result[0];
            end = result[1];
            if (end == null) {
                dummy.next = start;
                return res.next;
            }
            else {
                dummy.next = start;
                dummy = end;
            }
        }
    }

    public ListNode[] reverseKNode(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++){
            if (p.next == null) {
                return new ListNode[] { head.next, null };
            }
            p = p.next;
        }
        ListNode dummy = new ListNode(0);
        head = head.next;
        ListNode end = head;
        dummy.next = p.next;
        ListNode q;
        for (int i = 0; i < k; i++){
            p = dummy.next;
            dummy.next = head;
            q = head.next;
            head.next = p;
            head = q;
        }
        return new ListNode[] {dummy.next, end};
    }

    public static void main(String [] args){
        Problem25 p = new Problem25();
        int [] a = {1,2};
        LinkedList l1 = new LinkedList(a);
        System.out.println(p.reverseKGroup(l1.head, 3));
    }
}
