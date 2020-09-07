package UpTo1100;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        int n = grid.length;
        boolean[][] seen = new boolean[n][n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        seen[0][0] = true;
        int path = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            path++;
            for (int i = 0; i < size; i++) {
                int pos = q.poll();
                int x = pos / n, y = pos % n;
                for (int j = -1; j <= 1; j++) {
                    for (int k = -1; k <= 1; k++) {
                        int x2 = x + j, y2 = y + k;
                        if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= n || seen[x2][y2] || grid[x2][y2] == 1)
                            continue;
                        seen[x2][y2] = true;
                        if (x2 * n + y2 == n * n - 1) return ++path;
                        q.add(x2 * n + y2);
                    }
                }
            }
        }

        return -1;
    }
}
