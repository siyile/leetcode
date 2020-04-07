package UpTo400;

import utils.ListNode;

import java.util.Random;

public class Problem382 {
    private class Solution {
        ListNode head;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            Random rand = new Random();
            ListNode node = head;
            int k = 1;
            int select = -1;
            while (node != null) {
                int i = rand.nextInt(k);
                if (i == 0) {
                    select = node.val;
                }
                node = node.next;
                k++;
            }
            return select;
        }
    }
}
