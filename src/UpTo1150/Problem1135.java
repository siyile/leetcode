package UpTo1150;

import java.util.*;

public class Problem1135 {
    public int minimumCost(int N, int[][] connections) {
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        q.addAll(Arrays.asList(connections));

        int[] parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }
        Set<Integer> visited = new HashSet<>();
        int ans = 0;
        while (!q.isEmpty() && visited.size() != N) {
            int[] c = q.poll();
            int r1 = find(parent, c[1]), r2 = find(parent, c[0]);
            if (r1 != r2) {
                parent[r1] = r2;
                ans += c[2];
                N--;
            }
        }

        return N == 1 ? -1 : ans;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}
