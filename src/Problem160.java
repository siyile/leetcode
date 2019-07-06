import utils.ListNode;

public class Problem160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA, q = headB;
        while (p != q) {
            if (p.next == null)
                p = headB;
            else p = p.next;
            if (q.next == null)
                q = headA;
            else q = q.next;
        }
        return p;
    }
}
