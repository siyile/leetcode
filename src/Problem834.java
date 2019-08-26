import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem834 {
    int N;
    int[] sum;
    int[] count;
    List<List<Integer>> graph = new ArrayList<>();
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        this.N = N;
        sum = new int[N];
        count = new int[N];
        Arrays.fill(count, 1);
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][1]).add(edges[i][0]);
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return sum;
    }

    private void dfs(int node, int parent) {
        for (int child :
                graph.get(node)) {
            if (child != parent) {
                dfs(child, node);
                count[node] += count[child];
                sum[node] += sum[child] + count[child];
            }
        }
    }

    private void dfs2(int node, int parent) {
        for (int child :
                graph.get(node)) {
            if (child != parent) {
                sum[child] = sum[node] - count[child] + (N - count[child]);
                dfs2(child, node);
            }
        }
    }
}
