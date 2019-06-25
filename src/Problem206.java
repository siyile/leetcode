import utils.ListNode;

public class Problem206 {
    public ListNode reverseList0(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        ListNode q;
        while (p.next != null) {
            q = dummy.next;
            dummy.next = p.next;
            p.next = p.next.next;
            dummy.next.next = q;
        }
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
