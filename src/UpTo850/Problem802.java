package UpTo850;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 0 unvisited
        // 1 pending
        // 2 visited
        int[] color = new int[n];

        List<Integer> uncircle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (color[i] == 0)
                dfs(color, graph, i, uncircle);
        }

        Collections.sort(uncircle);
        return uncircle;
    }

    private boolean dfs(int[] color, int[][] graph, int node, List<Integer> uncircle) {
        if (color[node] == 1)
            return false;
        else if (color[node] == 2) {
            return true;
        }
        color[node] = 1;
        for (Integer x :
                graph[node]) {
            boolean possible = dfs(color, graph, x, uncircle);
            if (!possible)
                return false;
        }
        color[node] = 2;
        uncircle.add(node);
        return true;
    }
}
