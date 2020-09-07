package UpTo750;

import java.util.Map;
import java.util.TreeMap;

public class Problem715 {
    private class RangeModule {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public void addRange(int left, int right) {
            Map.Entry<Integer, Integer> from = map.floorEntry(left), to = map.floorEntry(right);
            if (from != null && from.getValue() >= left) {
                left = from.getKey();
            }
            if (to != null && to.getValue() > right) {
                right = to.getValue();
            }
            map.put(left, right);
            map.subMap(left, false, right, true).clear();
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> entry = map.floorEntry(left);
            if (entry == null) {
                return false;
            }
            return entry.getValue() >= right;
        }

        public void removeRange(int left, int right) {
            Map.Entry<Integer, Integer> from = map.floorEntry(left), to = map.floorEntry(right);
            if (to != null && to.getValue() > right) {
                map.put(right, to.getValue());
            }
            if (from != null && from.getValue() > left) {
                map.put(from.getKey(), left);
            }
            map.subMap(left, right).clear();
        }
    }

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
}
