public class Problem706 {
    private class MyHashMap {

        int HASH_KEY;
        Node[] map;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            HASH_KEY = 10000;
            map = new Node[HASH_KEY];
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash_key = key % HASH_KEY;
            if (map[hash_key] == null) {
                Node node = new Node(key, value);
                map[hash_key] = node;
            } else {
                Node node = new Node(-1, 0);
                node.next = map[hash_key];
                while (node.next != null) {
                    node = node.next;
                    if (node.key == key) {
                        node.val = value;
                        return;
                    }
                }
                node.next = new Node(key, value);
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash_key = key % HASH_KEY;
            if (map[hash_key] != null) {
                Node node = new Node(-1, 0);
                node.next = map[hash_key];
                while (node.next != null) {
                    node = node.next;
                    if (node.key == key) {
                        return node.val;
                    }
                }
            }
            return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash_key = key % HASH_KEY;
            if (map[hash_key] != null) {
                Node dummy = new Node(-1, 0);
                dummy.next = map[hash_key];
                Node node = dummy;
                while (node.next != null) {
                    if (node.next.key == key) {
                        node.next = node.next.next;
                        break;
                    }
                    node = node.next;
                }
                map[hash_key] = dummy.next;
            }
        }

        class Node {
            int key;
            int val;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
