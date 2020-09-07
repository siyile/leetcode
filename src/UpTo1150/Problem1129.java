package UpTo1150;

import java.util.*;

public class Problem1129 {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        // init
        List<List<List<Integer>>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            graph.get(0).add(new ArrayList<>());
            graph.get(1).add(new ArrayList<>());
        }
        init(graph.get(0), red_edges);
        init(graph.get(1), blue_edges);

        int[] ans = new int[n];
        Arrays.fill(ans, 801);
        bfs(graph, 0, ans);
        bfs(graph, 1, ans);

        for (int i = 0; i < n; i++) {
            if (ans[i] == n) ans[i] = -1;
        }

        return ans;
    }

    private void init(List<List<Integer>> graph, int[][] edges) {
        for (int[] edge : edges) graph.get(edge[0]).add(edge[1]);
    }

    private void bfs(List<List<List<Integer>>> graph, int color, int[] ans) {
        boolean[][] seen = new boolean[2][graph.get(0).size()];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        seen[color][0] = true;
        ans[0] = 0;
        int len = 0;
        while (!q.isEmpty()) {
            len++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int nei :
                        graph.get(color).get(node)) {
                    if (!seen[color][nei]) {
                        seen[color][nei] = true;
                        q.add(nei);
                        ans[nei] = Math.min(len, ans[nei]);
                    }
                }
            }
            color ^= 1;
        }
    }
}
