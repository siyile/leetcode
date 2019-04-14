import utils.LinkedList;
import utils.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Problem23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        int lastOne = -1;
        boolean nullFlag = true;
        for (int i = 0; i < len; i++) {
            if (lists[i] != null && lastOne != -1) {
                nullFlag = false;
                break;
            } else if (lists[i] != null) lastOne = i;
        }
        if (lastOne == -1) {
            return null;
        }
        if (nullFlag) {
            return lists[lastOne];
        }
        int s = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (lists[i] != null && lists[i].val < min) {
                s = i;
                min = lists[i].val;
            }
        }
        ListNode p = lists[s];
        lists[s] = p.next;
        p.next = mergeKLists(lists);
        return p;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        Comparator<ListNode> comparator = new ListNodeComparator();
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(7, comparator);
        for (ListNode l : lists) {
            if (l != null) {
                queue.add(l);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            node = node.next;
            if (node != null) queue.add(node);
        }
        return head.next;
    }

    public class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        int len = lists.length;
        if (len == 0){
            return null;
        }
        int interval = 1;
        while (interval < len){
            for (int i = 0; i < len - interval; i+= interval * 2){
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;

            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }
        return head;
    }

    public static void main(String[] args) {
        Problem23 p = new Problem23();
        int[] a = {1, 5, 6};
        int[] b = {6, 6};
        int[] c = {2, 4, 9};
        LinkedList l1 = new LinkedList(a);
        LinkedList l2 = new LinkedList(b);
        LinkedList l3 = new LinkedList(c);
        System.out.println(p.mergeKLists3(new ListNode[]{l1.head, l2.head, l3.head}));
    }
}

