public class Problem706 {
    class MyHashMap {
        int HASH_KEY = 10000;
        Node[] map;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            map = new Node[HASH_KEY];
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            Node p = map[hashcode(key)];
            if (p == null) {
                map[hashcode(key)] = new Node(key, value);
            } else {
                while (p.next != null && p.key != key) {
                    p = p.next;
                }
                if (p.key == key) {
                    p.value = value;
                } else {
                    p.next = new Node(key, value);
                }
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            Node p = map[hashcode(key)];
            if (p == null) {
                return -1;
            } else {
                while (p != null && p.key != key) {
                    p = p.next;
                }
                if (p != null) {
                    return p.value;
                } else {
                    return -1;
                }
            }
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int hashKey = hashcode(key);
            if (map[hashKey] != null) {
                Node p = map[hashKey];
                Node dummy = new Node(0, 0);
                dummy.next = p;
                Node prev = dummy;
                while (p != null && p.key != key) {
                    p = p.next;
                    prev = prev.next;
                }
                if (p != null) {
                    prev.next = p.next;
                    map[hashKey] = dummy.next;
                }
            }
        }

        public int hashcode(int key) {
            return key % HASH_KEY;
        }

        class Node {
            int key;
            int value;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

}
