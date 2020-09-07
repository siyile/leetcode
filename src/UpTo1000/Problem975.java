package UpTo1000;

import java.util.Map;
import java.util.TreeMap;

public class Problem975 {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        boolean[] hi = new boolean[n];
        boolean[] lo = new boolean[n];
        hi[n - 1] = lo[n - 1] = true;
        map.put(A[n - 1], n - 1);
        int ans = 1;
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(A[i]);
            if (entry != null) {
                hi[i] = lo[entry.getValue()];
            }
            entry = map.floorEntry(A[i]);
            if (entry != null) {
                lo[i] = hi[entry.getValue()];
            }
            map.put(A[i], i);
            if (hi[i]) {
                ans += 1;
            }
        }
        return ans;
    }
}
