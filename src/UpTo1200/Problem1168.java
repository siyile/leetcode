package UpTo1200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem1168 {
    int[] parent;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        parent = new int[n++];
        List<int[]> edges = new ArrayList<>();
        for (int[] pipe :
                pipes) {
            edges.add(pipe);
        }
        for (int i = 1; i < n; i++) {
            edges.add(new int[]{0, i, wells[i - 1]});
            parent[i] = i;
        }
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int ans = 0;
        for (int[] edge :
                edges) {
            if (n == 1) break;
            int x = find(edge[0]);
            int y = find(edge[1]);
            if (x != y) {
                parent[x] = y;
                ans += edge[2];
            }
        }
        return ans;
    }

    private int find(int i) {
        if (parent[i] == i) return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }
}
