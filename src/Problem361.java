public class Problem361 {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int[][] l = new int[m + 2][n + 2], r = new int[m + 2][n + 2], t = new int[m + 2][n + 2], b = new int[m + 2][n + 2];
        int ans = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = grid[i - 1][j - 1];
                if (ch == 'E') l[i][j] = 1 + l[i][j - 1];
                else if (ch == '0') l[i][j] = l[i][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 0; j--) {
                char ch = grid[i - 1][j - 1];
                if (ch == 'E') r[i][j] = 1 + r[i][j + 1];
                else if (ch == '0') r[i][j] = r[i][j + 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char ch = grid[i - 1][j - 1];
                if (ch == 'E') t[i][j] = 1 + t[i - 1][j];
                else if (ch == '0') t[i][j] = t[i - 1][j];
            }
        }

        for (int i = m; i > 0; i--) {
            for (int j = 1; j <= n; j++) {
                char ch = grid[i - 1][j - 1];
                if (ch == 'E') b[i][j] = 1 + b[i + 1][j];
                else if (ch == '0') {
                    b[i][j] = b[i + 1][j];
                    ans = Math.max(l[i][j] + r[i][j] + t[i][j] + b[i][j], ans);
                }
            }
        }

        return ans;
    }
}
