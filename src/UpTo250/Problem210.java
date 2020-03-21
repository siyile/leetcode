package UpTo250;

import java.util.*;

public class Problem210 {
    public int[] findOrder(int n, int[][] prerequisites) {
        boolean[] seen = new boolean[n];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(i);
        }
        for (int[] pre :
                prerequisites) {
            edges.get(pre[0]).add(pre[1]);
            s.remove(pre[0]);
        }

        List<Integer> path = new ArrayList<>();

        // bfs
        for (Integer start :
                s) {
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int node = q.poll();
                    for (Integer next :
                            edges.get(node)) {
                        if (!seen[next]) {
                            seen[next] = true;
                            path.add(next);
                            q.add(next);
                        }
                    }
                }
            }
        }


        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = path.get(i);
        }

        return ans;
    }
}
