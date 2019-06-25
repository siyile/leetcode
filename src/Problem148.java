import utils.LinkedList;
import utils.ListNode;

public class Problem148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        ListNode left;
        ListNode right;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur;
        ListNode next;
        for (int step = 1; step < len; step <<= 1) {
            cur = dummy;
            while (cur.next != null) {
                left = cur.next;
                right = split(left, step);
                next = split(right, step);
                cur = merge(cur, left, right);
                cur.next = next;
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode start, int step) {
        // return next
        for (int i = 0; start != null && i < step - 1; i++) {
            start = start.next;
        }
        if (start == null) return null;
        ListNode end = start.next;
        start.next = null;
        return end;
    }

    private ListNode merge(ListNode prev, ListNode left, ListNode right) {
        // return start
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        if (left == null) {
            node.next = right;
        } else {
            node.next = left;
        }
        while (node.next != null) node = node.next;
        prev.next = dummy.next;
        return node;
    }

    public static void main(String[] args) {
        Problem148 p = new Problem148();
        LinkedList l = new LinkedList(new int[]{4,2,1,3,5,89,3,123,45,6,3,1,44,5,62,1,2,2});
        System.out.println(p.sortList(l.head));
    }
}

