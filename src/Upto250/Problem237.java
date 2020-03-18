package Upto250;

import utils.ListNode;

public class Problem237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
