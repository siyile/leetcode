package UpTo200;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Problem200 {
    public int dfs(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length, cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }

    public int bfs(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length, cnt = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    grid[i][j] = '0';
                    q.add(new Point(i, j));
                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int k = 0; k < size; k++) {
                            Point point = q.poll();
                            int x = point.x, y = point.y;
                            for (int[] dir :
                                    dirs) {
                                int Y = y + dir[1];
                                int X = x + dir[0];
                                if (X < 0 || Y < 0 || X >= m || Y >= n) continue;
                                if (grid[X][Y] == '1') {
                                    grid[X][Y] = '0';
                                    q.add(new Point(X, Y));
                                }
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
