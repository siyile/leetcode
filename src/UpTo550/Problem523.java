package UpTo550;

import java.util.HashMap;
import java.util.Map;

public class Problem523 {
    public static void main(String[] args) {
        Problem523 p = new Problem523();

        System.out.println(p.checkSubarraySum(new int[]{0, 0}, 0));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if (k < 0) k = -k;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum %= k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
