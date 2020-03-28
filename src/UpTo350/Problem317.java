package UpTo350;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem317 {
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] reach = new int[m][n];
        int[][] dis = new int[m][n];
        int bcnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bcnt--;
                    bfs(i, j, dis, reach, grid, bcnt);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == bcnt && reach[i][j] == bcnt) {
                    ans = Math.min(ans, dis[i][j]);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void bfs(int i, int j, int[][] dis, int[][] reach, int[][] grid, int mark) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int k = 0; k < size; k++) {
                int[] pos = q.poll();
                int x = pos[0], y = pos[1];
                for (int[] dir :
                        dirs) {
                    int xp = x + dir[0], yp = y + dir[1];
                    if (xp < m && yp < n && xp >= 0 && yp >= 0 && grid[xp][yp] == mark + 1) {
                        grid[xp][yp] = mark;
                        q.add(new int[]{xp, yp});
                        dis[xp][yp] += cnt;
                        reach[xp][yp]--;
                    }
                }
            }
        }
    }
}
