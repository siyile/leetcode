package UpTo800;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem785 {
    public boolean isBipartiteBfs(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] != -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        Integer node = q.poll();

                        for (int x :
                                graph[node]) {
                            if (color[x] == -1) {
                                q.add(x);
                                color[x] = color[node] ^ 1;
                            } else if (color[x] == color[node]) {
                                return false;
                            }
                        }
                    }
                }

            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // pending 0, red 1, blue -1
        int[] colors = new int[n];
        for (int i = 0; i < n; i++)
            if (colors[i] == 0 && !dfs(i, 1, graph, colors))
                return false;
        return true;
    }

    private boolean dfs(int i, int color, int[][] graph, int[] colors) {
        if (colors[i] != 0) return colors[i] == color;
        colors[i] = color;
        for (int nei : graph[i])
            if (!dfs(nei, -color, graph, colors))
                return false;
        return true;
    }
}
