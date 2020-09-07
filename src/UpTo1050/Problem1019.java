package UpTo1050;

import utils.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem1019 {
    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> s = new ArrayDeque<>();
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int[] ans = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= list.get(i)) {
                s.poll();
            }
            ans[i] = s.isEmpty() ? 0 : s.peek();
            s.push(list.get(i));
        }

        return ans;
    }
}
