package UpTo500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem465 {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t :
                transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }

        List<Integer> l = new ArrayList<>(map.values());
        return dfs(0, l);
    }

    private int dfs(int i, List<Integer> l) {
        int n = l.size();
        while (i < n && l.get(i) == 0)
            i++;
        if (i == n) return 0;
        int cnt = Integer.MAX_VALUE;
        for (int j = i + 1; j < n; j++) {
            if (l.get(i) * l.get(j) < 0) {
                l.set(j, l.get(j) + l.get(i));
                cnt = Math.min(cnt, 1 + dfs(i + 1, l));
                l.set(j, l.get(j) - l.get(i));
            }
        }
        return cnt;
    }
}
