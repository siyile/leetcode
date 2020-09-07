package UpTo900;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem882 {
    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], -1);
        }

        for (int[] edge :
                edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
        q.offer(new int[]{0, M});
        boolean[] visited = new boolean[N];

        int ans = 0;
        while (q.size() != 0) {
            int[] state = q.poll();
            if (visited[state[0]]) {
                continue;
            }
            visited[state[0]] = true;

            int cur = state[0];
            int mov = state[1];
            ans++;
            for (int i = 0; i < N; i++) {
                if (graph[cur][i] > -1) {
                    if (mov > graph[cur][i] && !visited[i]) {
                        q.offer(new int[]{i, mov - graph[cur][i] - 1});
                    }
                    graph[i][cur] -= Math.min(mov, graph[cur][i]);
                    ans += Math.min(mov, graph[cur][i]);
                }
            }
        }
        return ans;
    }
}
