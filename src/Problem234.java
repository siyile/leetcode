import utils.ListNode;

public class Problem234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow, fast;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        slow = dummy;
        fast = dummy.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = reverse(slow.next);
        ListNode p = dummy.next, q = slow.next;
        while (q != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy.next;
        while (p.next != null) {
            ListNode q = p.next;
            p.next = p.next.next;
            q.next = dummy.next;
            dummy.next = q;
        }
        return dummy.next;
    }
}
