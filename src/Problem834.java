import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem834 {
    int[] ans, count;
    int N;
    List<HashSet<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        ans = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge :
                edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int node, int parent) {
        for (Integer child :
                graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
                count[parent] += count[child];
                ans[parent] += ans[child] + count[child];
            }
        }
    }

    public void dfs2(int node, int parent) {
        for (Integer child :
                graph.get(node)) {
            if (child != parent) {
                ans[child] = ans[node] + (N - count[child]) - count[child];
                dfs2(child, node);
            }
        }
    }
}
