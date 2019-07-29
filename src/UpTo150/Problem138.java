package UpTo150;

import java.util.HashMap;
import java.util.Map;

/*
// Definition for a Node.

*/

public class Problem138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Node node;
        while (cur != null) {
            node = new Node(cur.val, cur.next, cur.random);
            cur.next = node;
            cur = node.next;
        }
        cur = head.next;
        while (cur != null) {
            if (cur.random != null) cur.random = cur.random.next;
            if (cur.next != null) cur = cur.next.next;
            else break;
        }
        cur = head;
        node = head.next;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = temp.next;
            cur = cur.next;
            if (cur != null) temp.next = cur.next;
        }
        return node;
    }

    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        Node next;
        Node random;
        Node node;
        while (cur != null) {
            if (!map.containsKey(cur)) {
                node = new Node(cur.val, null, null);
                map.put(cur, node);
            } else {
                node = map.get(cur);
            }
            if (cur.next != null) {
                if (!map.containsKey(cur.next)) {
                    next = new Node(cur.next.val, null, null);
                    map.put(cur.next, next);
                    node.next = next;
                } else {
                    node.next = map.get(cur.next);
                }
            }
            if (cur.random != null) {
                if (!map.containsKey(cur.random)) {
                    random = new Node(cur.random.val, null, null);
                    map.put(cur.random, random);
                    node.random = random;
                } else {
                    node.random = map.get(cur.random);
                }
            }
            cur = cur.next;
        }
        return map.get(head);
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
