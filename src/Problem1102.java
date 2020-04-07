public class Problem1102 {
    public int maximumMinimumPath(int[][] A) {
        int l = 0, r = 1_000_000_001;
        while (l + 1 < r) {
            int m = (r - l) / 2 + l;
            if (possible(A, m))
                l = m;
            else
                r = m;
        }
        return l;
    }

    private boolean possible(int[][] A, int min) {
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(A, visited, min, 0, 0);
    }

    private boolean dfs(int[][] A, boolean[][] visited, int min, int x, int y) {
        int m = A.length, n = A[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n) return false;
        if (visited[x][y])
            return false;
        visited[x][y] = true;
        if (A[x][y] < min) return false;
        if (x == m - 1 && y == n - 1) return true;
        return dfs(A, visited, min, x + 1, y) ||
                dfs(A, visited, min, x, y - 1) ||
                dfs(A, visited, min, x - 1, y) ||
                dfs(A, visited, min, x, y + 1);
    }
}
