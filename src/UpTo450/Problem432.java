package UpTo450;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem432 {
    private class AllOne {
        Bucket tail;
        Bucket head;

        Map<Integer, Bucket> count2Bucket = new HashMap<>();
        Map<String, Integer> key2count = new HashMap<>();

        private class Bucket {
            Bucket pre;
            Bucket next;
            int count;
            Set<String> set = new HashSet<>();

            public Bucket(int count) {
                this.count = count;
            }
        }

        /** Initialize your data structure here. */
        public AllOne() {
            tail = new Bucket(Integer.MAX_VALUE);
            head = new Bucket(Integer.MIN_VALUE);
            tail.pre = head;
            head.next = tail;
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            if (key2count.containsKey(key)) {
                changeKey(key, 1);
            } else {
                key2count.put(key, 1);
                if (head.next.count != 1) {
                    addAfter(new Bucket(1), head);
                }
                head.next.set.add(key);
                count2Bucket.put(1, head.next);
            }
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if (key2count.containsKey(key)) {
                int count = key2count.get(key);
                if (count == 1) {
                    key2count.remove(key);
                    removeKeyFromBucket(count2Bucket.get(1), key);
                } else {
                    changeKey(key, -1);
                }
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            return tail.pre.count == Integer.MIN_VALUE ? "" : tail.pre.set.iterator().next();
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            return head.next.count == Integer.MAX_VALUE ? "" : head.next.set.iterator().next();
        }

        private void changeKey(String key, int offset) {
            // assume key already exist
            int count = key2count.get(key);
            key2count.put(key, count + offset);

            Bucket bucket = count2Bucket.get(count);
            Bucket newBucket;

            if (count2Bucket.containsKey(count + offset)) {
                newBucket = count2Bucket.get(count + offset);
            } else {
                newBucket = new Bucket(count + offset);
                addAfter(newBucket, offset == 1 ? bucket : bucket.pre);
                count2Bucket.put(count + offset, newBucket);
            }

            newBucket.set.add(key);
            removeKeyFromBucket(bucket, key);
        }

        private void removeKeyFromBucket(Bucket bucket, String key) {
            bucket.set.remove(key);
            if (bucket.set.size() == 0) {
                removeBucket(bucket);
                count2Bucket.remove(bucket.count);
            }
        }

        private void removeBucket(Bucket bucket) {
            bucket.next.pre = bucket.pre;
            bucket.pre.next = bucket.next;
        }

        private void addAfter(Bucket bucket, Bucket preBucket) {
            bucket.next = preBucket.next;
            bucket.pre = preBucket;
            preBucket.next = bucket;
            bucket.next.pre = bucket;
        }
    }

}
