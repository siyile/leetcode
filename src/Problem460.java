import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Problem460 {
    private class LFUCache {


        Map<Integer, Integer> keyToVal = new HashMap<>();
        Map<Integer, Integer> keyToCnt = new HashMap<>();
        Map<Integer, LinkedHashSet<Integer>> cntToLRU = new HashMap<>();

        int capacity;
        int min;
        public LFUCache(int capacity) {
            int min = 0;
            this.capacity = capacity;
            min = -1;
        }

        public int get(int key) {
            if (!keyToCnt.containsKey(key))
                return -1;

            int count = keyToCnt.get(key);
            cntToLRU.get(count).remove(key);

            if (count == min && cntToLRU.get(min).size() == 0)
                min++;

            putCount(key, count + 1);
            return keyToVal.get(key);
        }

        public void put(int key, int value) {
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                get(key);
                return;
            }

            if (capacity <= 0) return;

            if (keyToVal.size() >= capacity) {
                evict(cntToLRU.get(min).iterator().next());
            }

            min = 1;
            putCount(key, 1);
            keyToVal.put(key, value);
        }

        private void evict(int key) {
            keyToVal.remove(key);
            int cnt = keyToCnt.get(key);
            cntToLRU.get(cnt).remove(key);
            keyToCnt.remove(key);
        }

        private void putCount(int key, int count) {
            keyToCnt.put(key, count);
            cntToLRU.computeIfAbsent(count, ignore -> new LinkedHashSet<>());
            cntToLRU.get(count).add(key);
        }
    }
}
