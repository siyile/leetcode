package UpTo550;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem547 {
    public int dfs(int[][] M) {
        int n = M.length;
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                visited[i] = true;
                dfs(M, visited, i);
            }
        }
        return cnt;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        int n = M.length;
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[i] = true;
                dfs(M, visited, j);
            }
        }
    }

    private int bfs(int[][] M) {
        int n = M.length;
        boolean[] seen = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                cnt++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                seen[i] = true;
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        int x = q.poll();
                        for (int k = 0; k < n; k++) {
                            if (M[x][k] == 1 && !seen[k]) {
                                q.add(k);
                                seen[k] = true;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }

    private int unionFind(int[][] M) {
        int n = M.length;
        int[] parent = new int[n];
        int[] rate = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    union(parent, rate, i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(parent, i));
        }
        return set.size();
    }

    private void union(int[] parent, int[] rate, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            if (rate[rootX] > rate[rootY]) {
                parent[rootY] = rootX;
                rate[rootX]++;
            } else {
                parent[rootX] = rootY;
                rate[rootY]++;
            }
        }
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
            return parent[x];
        }
        return x;
    }
}
