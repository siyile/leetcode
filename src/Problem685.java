import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        List<Integer> first = new ArrayList<>(), second = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            graph.add(new ArrayList<>());
        }
        for (int[] edge :
                edges) {
            int x = edge[0], y = edge[1];
            graph.get(y).add(x);
            if (graph.get(y).size() == 2) {
                second = Arrays.asList(x, y);
                first = Arrays.asList(graph.get(y).get(0), y);
            }
        }

        for (int[] edge :
                edges) {
            int x = edge[0], y = edge[1], rx = find(parent, x), ry = find(parent, y);
            if (first.size() > 0 && x == first.get(0) && y == first.get(1)) continue;
            if (rx != y)
                parent[rx] = ry;
            else {
                if (second.size() != 0)
                    return new int[]{second.get(0), second.get(1)};
                else return edge;
            }
        }

        return new int[]{first.get(0), first.get(1)};
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
            return parent[i];
        }
        return i;
    }
}
