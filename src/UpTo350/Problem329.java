package UpTo350;

public class Problem329 {
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if (m == 0) return 0;
        n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j, cache, matrix));
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] cache, int[][] matrix) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] dir :
                dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(x, y, cache, matrix));
            }
        }
        return ++cache[i][j];
    }
}
