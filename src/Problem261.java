import java.util.ArrayList;
import java.util.List;

public class Problem261 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge :
                edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // unvisit 0 pending 1 visited 2
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (!dfs(graph, color, i, -1))
                return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] color, int node, int parent) {
        if (color[node] == 1) return false;
        if (color[node] == 2) return true;
        color[node] = 1;
        for (int nei :
                graph.get(node)) {
            if (nei != parent && !dfs(graph, color, nei, node))
                return false;
        }
        color[node] = 2;
        return true;
    }
}
