import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem981 {
    private class TimeMap {
        Map<String, TreeMap<Integer, String>> store = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> map;
            if (store.containsKey(key)) {
                map = store.get(key);
            } else {
                map = new TreeMap<>();
                store.put(key, map);
            }
            map.put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!store.containsKey(key)) {
                return "";
            } else {
                Map.Entry<Integer, String> entry = store.get(key).floorEntry(timestamp);
                if (entry == null)
                    return "";
                else return entry.getValue();
            }
        }
    }
}
