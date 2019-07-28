import java.util.ArrayList;
import java.util.List;

public class Problem886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] edge :
                dislikes) {
            edges.get(edge[0] - 1).add(edge[1] - 1);
            edges.get(edge[1] - 1).add(edge[0] - 1);
        }

        // 0 unpainted
        // 1 red
        // -1 blue
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !dfs(color, edges, i, 1))
                return false;
        }
        return true;
    }

    private boolean dfs(int[] color, List<List<Integer>> edges, int node, int paint) {
        color[node] = paint;
        for (Integer nei :
                edges.get(node)) {
            if (color[nei] != 0) {
                if (color[nei] + color[node] != 0)
                    return false;
            } else {
                if (!dfs(color, edges, nei, ~nei + 1))
                    return false;
            }

        }
        return true;
    }
}
