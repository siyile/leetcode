package UpTo150;

import java.util.HashMap;
import java.util.Map;

public class Problem146 {
    public static void main(String[] args) {
        Problem146 p = new Problem146();
        p.wrapper();
    }

    public void wrapper() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

    private class LRUCache {

        Node head;
        Node tail;
        Map<Integer, Node> map;
        int capacity;

        public LRUCache(int capacity) {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>();
            this.capacity = capacity;
        }

        private Node add(int key, int val) {
            Node node = new Node(key, val);
            node.prev = head;
            node.next = head.next;
            head.next = node;
            node.next.prev = node;
            return node;
        }

        private Node update(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
            return node;
        }

        private Node remove() {
            Node node = tail.prev;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            return node;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                update(node);
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = update(map.get(key));
                node.val = value;
            } else {
                if (capacity > 0) {
                    map.put(key, add(key, value));
                    capacity--;
                } else {
                    map.remove(remove().key);
                    map.put(key, add(key, value));
                }
            }
        }

        class Node {
            Node prev;
            Node next;
            int val;
            int key;

            public Node() {
            }

            Node(int key, int val) {
                this.val = val;
                this.key = key;
            }
        }
    }
}
