import utils.ListNode;

import java.util.Stack;

public class Problem445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummy = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = s1.isEmpty() ? 0 : s1.pop().val;
            int b = s1.isEmpty() ? 0 : s1.pop().val;
            ListNode p = new ListNode((a + b + carry) % 10);
            p.next = dummy.next;
            dummy.next = p;
            carry = (a + b + carry) / 10;
        }
        if (carry != 0) {
            ListNode p = new ListNode(1);
            p.next = dummy.next;
            dummy.next = p;
        }
        return dummy.next;
    }
}
