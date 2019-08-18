package UpTo150;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem147 {
    public ListNode insertionSortList(ListNode head) {
        List<Integer> copy = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            copy.add(node.val);
            node = node.next;
        }
        Collections.sort(copy);
        node = head;
        for (Integer x :
                copy) {
            node.val = x;
            node = node.next;
        }
        return head;
    }
}
