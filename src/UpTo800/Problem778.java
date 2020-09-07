package UpTo800;

public class Problem778 {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = 0, r = n * n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (possible(grid, m)) r = m;
            else l = m + 1;
        }
        return l;
    }

    private boolean possible(int[][] grid, int t) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        return dfs(0, 0, grid, visited, t, dir);
    }

    private boolean dfs(int x, int y, int[][] grid, boolean[][] visited, int t, int[][] dir) {
        int n = grid.length;
        if (x < 0 || y < 0 || x >= n || y >= n) return false;
        if (visited[x][y]) return false;
        if (grid[x][y] <= t) {
            visited[x][y] = true;
            if (x == n - 1 && y == n - 1) return true;
        } else return false;
        for (int i = 0; i < 4; i++) {
            int X = dir[i][0] + x, Y = dir[i][1] + y;
            if (dfs(X, Y, grid, visited, t, dir)) return true;
        }
        return false;
    }
}
