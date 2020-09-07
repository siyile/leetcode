package UpTo1150;

public class Problem1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        int[][] top = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                top[i][j] = grid[i - 1][j - 1] == 0 ? 0 : top[i - 1][j] + 1;
            }
        }

        int[][] left = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                left[i][j] = grid[i - 1][j - 1] == 0 ? 0 : left[i][j - 1] + 1;
                top[i][j] = Math.min(top[i][j], left[i][j]);
            }
        }

        int[][] bottom = new int[m + 2][n + 2];
        for (int i = m; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                bottom[i][j] = grid[i - 1][j - 1] == 0 ? 0 : bottom[i + 1][j] + 1;
            }
        }

        int[][] right = new int[m + 2][n + 2];
        for (int i = m; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                right[i][j] = grid[i - 1][j - 1] == 0 ? 0 : right[i][j + 1] + 1;
                bottom[i][j] = Math.min(bottom[i][j], right[i][j]);
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < top[i][j]; k++) {
                    int x = i - k, y = j - k;
                    int a = 0;
                    if (bottom[x][y] >= k + 1) {
                        a = k + 1;
                    }
                    ans = Math.max(a, ans);
                }
            }
        }
        return ans * ans;
    }
}
