package Upto250;

import java.util.HashMap;
import java.util.Map;

public class Problem219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                diff = Math.min(diff, i - map.get(nums[i]));
                map.put(i, nums[i]);
                if (diff <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
