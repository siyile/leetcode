import java.util.*;

public class Problem668 {
    public static void main(String[] args) {
        Problem668 p = new Problem668();
        Set[] x = new HashSet[1];
    }

    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mi = (l + r) / 2;
            if (!enough(m, n, mi, k)) {
                l = mi + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private boolean enough(int m, int n, int x, int k) {
        int count = 0;
        for (int i = 1; i < m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        Set[] red = new HashSet[n];
        Set[] blue = new HashSet[n];
        init(red, red_edges);
        init(blue, blue_edges);
        Map<Integer, Set[]> colors = new HashMap<>();
        colors.put(0, blue);
        colors.put(1, red);
        boolean[] reach = new boolean[n];

        bfs(colors, ans, 1, reach);
        bfs(colors, ans, 0, reach);

        return ans;
    }

    private void init(Set[] sets, int[][] edges) {
        for (int[] edge :
                edges) {
            Set<Integer> s;
            if (sets[edge[0]] == null) {
                s = new HashSet<>();
            } else {
                s = sets[edge[0]];
            }
            s.add(edge[1]);
        }
    }

    private void bfs(Map<Integer, Set[]> colors, int[] ans, int color, boolean[] reach) {
        Set[] seen = new Set[2];
        seen[0] = new HashSet<Integer>();
        seen[1] = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        seen[color].add(0);
        int dis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int next = color;
            if (color == 0) color = 1;
            else color = 0;
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                Set<Integer> s = colors.get(next)[node];
                for (Integer x :
                        s) {
                    if (!seen[next].contains(x)) {
                        q.add(x);
                        seen[next].add(x);
                        if (!reach[x]) {
                            reach[x] = true;
                            ans[x] = dis;
                        }
                    }
                }
            }
            dis++;
        }
    }
}
