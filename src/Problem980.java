public class Problem980 {
    int m, n, ans = 0, empty = 1;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // init
        int sx = 0, sy = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int el = grid[i][j];
                if (el == 0) empty++;
                else if (el == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }

        dfs(sx, sy, grid);
        return ans;
    }

    private void dfs(int x, int y, int[][] grid) {
        if (!check(x, y, grid)) return;
        if (empty == 0) {
            if (grid[x][y] == 2)
                ans++;
            return;
        }
        grid[x][y] = -1;
        empty--;
        dfs(x + 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x, y - 1, grid);
        dfs(x - 1, y, grid);
        empty++;
        grid[x][y] = 0;
    }

    private boolean check(int x, int y, int[][] grid) {
        int m = grid.length, n = grid[0].length;
        return x >= 0 && y >= 0 && x < m && y < n && grid[x][y] != -1;
    }
}
