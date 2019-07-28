import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem261 {
    boolean possible = true;

    public boolean validTree(int n, int[][] edges) {
        if (n == 1) {
            return true;
        }
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int[] edge :
                edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        dfs(tree, 0, -1, visited);
        if (!possible) return false;
        return visited.size() == n;
    }

    private void dfs(List<List<Integer>> tree, int node, int parent, Set<Integer> visited) {
        if (!possible) return;
        visited.add(node);
        for (Integer nei :
                tree.get(node)) {
            if (visited.contains(node)) {
                if (node != parent) {
                    possible = false;
                    return;
                } else continue;
            }
            dfs(tree, nei, node, visited);
        }
    }
}
