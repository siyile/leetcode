package UpTo450;

import java.util.HashSet;
import java.util.Set;

public class Problem421 {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            Set<Integer> set = new HashSet<>();
            mask |= 1 << i;
            for (int num :
                    nums) {
                set.add(num & mask);
            }
            int greedyMax = max | (1 << i);
            for (int num :
                    set) {
                int anotherNum = greedyMax ^ num;
                if (set.contains(anotherNum)) {
                    max = greedyMax;
                    break;
                }
            }
        }
        return max;
    }
}
