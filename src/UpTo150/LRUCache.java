package UpTo150;

import java.util.HashMap;

public class LRUCache {
    DLinkedNode head = new DLinkedNode();
    DLinkedNode tail = new DLinkedNode();
    HashMap<Integer, DLinkedNode> map = new HashMap<>();
    int capacity;
    int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.post = tail;
        tail.pre = head;
    }

    private void add(DLinkedNode node) {
        head.post.pre = node;
        node.post = head.post;
        node.pre = head;
        head.post = node;
    }

    private void delete(DLinkedNode node) {
        DLinkedNode nodePost = node.post;
        node.post.pre = node.pre;
        node.pre.post = nodePost;
    }

    private void moveToHead(DLinkedNode node) {
        delete(node);
        add(node);
    }

    private void popTail() {
        DLinkedNode node = tail.pre;
        map.remove(node.key);
        delete(node);
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            if (count == capacity) {
                popTail();
            } else {
                count++;
            }
            node = new DLinkedNode(key, value);
            add(node);
            map.put(key, node);
        }
    }

    /**
     * Your UpTo150.LRUCache object will be instantiated and called as such:
     * UpTo150.LRUCache obj = new UpTo150.LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    class DLinkedNode {
        int value;
        int key;
        DLinkedNode pre;
        DLinkedNode post;

        DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        DLinkedNode() {
        }
    }
}
