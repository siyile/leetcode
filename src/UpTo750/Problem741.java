package UpTo750;

import java.util.Arrays;

public class Problem741 {
    int[][][] memo;
    int n;
    int[][] grid;

    public static void main(String[] args) {
        Problem741 p = new Problem741();

        System.out.println(p.cherryPickup(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}));
    }

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        memo = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], Integer.MIN_VALUE);
            }
        }

        return Math.max(0, dp(0, 0, 0));
    }

    public int dp(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;
        if (r1 >= n || r2 >= n || c1 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) return -1_000_000_000;
        else if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];
        else if (memo[r1][c1][r2] != Integer.MIN_VALUE) return memo[r1][c1][r2];
        else {
            int ans = grid[r1][c1];
            if (c1 != c2) ans += grid[r2][c2];
            memo[r1][c1][r2] = ans + Math.max(dp(r1 + 1, c1, r2), Math.max(dp(r1, c1 + 1, r2),
                    Math.max(dp(r1 + 1, c1, r2 + 1), dp(r1, c1 + 1, r2 + 1))));
            return memo[r1][c1][r2];
        }
    }
}
