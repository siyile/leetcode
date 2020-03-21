package UpTo250;

import java.util.HashMap;
import java.util.Map;

public class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long mappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = mappedNum / ((long) t + 1);
            if (map.containsKey(bucket) || map.containsKey(bucket - 1) && mappedNum - map.get(bucket - 1) <= t || map.containsKey(bucket + 1) && map.get(bucket + 1) - mappedNum <= t) {
                return true;
            }
            if (map.size() >= k) {
                map.remove(((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1));
            }
            map.put(bucket, mappedNum);
        }
        return false;
    }
}
