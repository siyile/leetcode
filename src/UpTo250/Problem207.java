package UpTo250;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem207 {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] degree = new int[n];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p :
                prerequisites) {
            degree[p[1]]++;
            graph.get(p[0]).add(p[1]);
        }

        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 0)
                q.add(i);
        }
        n -= q.size();
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei :
                    graph.get(node)) {
                if (--degree[nei] == 0) {
                    q.add(nei);
                    n--;
                }
            }
        }

        return n == 0;
    }
}
