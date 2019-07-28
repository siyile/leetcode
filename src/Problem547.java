import java.util.*;

public class Problem547 {
    public int findCircleNum(int[][] M) {
        // bfs
//        return bfs(M);
        // dfs
        return dfs(M);
        // union_found
    }

    private int bfs(int[][] M) {
        int n = M.length;
        int cnt = 0;
        boolean[] seen = new boolean[n];

        for (int k = 0; k < n; k++) {
            if (!seen[k]) {
                seen[k] = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(k);
                cnt++;
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int i = 0; i < size; i++) {
                        int x = q.poll();
                        for (int j = 0; j < n; j++) {
                            if (!seen[j] && M[x][j] != 0) {
                                seen[j] = true;
                                q.add(j);
                            }
                        }
                    }
                }
            }
        }

        return cnt;
    }

    private int dfs(int[][] M) {
        int n = M.length;
        int cnt = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                Stack<Integer> s = new Stack<>();
                s.push(i);
                while (!s.isEmpty()) {
                    int x = s.pop();
                    if (!visited[x]) {
                        visited[x] = true;
                        for (int j = 0; j < n; j++) {
                            if (!visited[j] && M[x][j] != 0) {
                                s.push(j);
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
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int x = find(i, parent);
                int y = find(j, parent);
                if (x == y)
                    continue;
                union(x, y, parent);
            }
        }

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(find(i, parent));
        }

        return s.size();
    }

    private int find(int node, int[] parent) {
        if (parent[node] == -1)
            return node;
        return find(parent[node], parent);
    }

    private void union(int x, int y, int[] parent) {
        int setX = find(x, parent);
        int setY = find(y, parent);
        parent[setX] = setY;
    }
}
