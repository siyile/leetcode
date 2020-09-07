package UpTo1050;

import java.util.Arrays;

public class Problem1039 {
    private int[][] memo;

    public static void main(String[] args) {
        Problem1039 p = new Problem1039();

        System.out.println(p.minScoreTriangulation(new int[]{35, 73, 90, 27, 71, 80, 21, 33, 33, 13, 48, 12, 68, 70, 80, 36, 66, 3, 70, 58}));
    }

    public int minScoreTriangulation2(int[] points) {
        int n = points.length;
        memo = new int[n + 1][n + 1];
        return reconstruct(points, 0, points.length);
    }

    private int reconstruct(int[] points, int start, int end) {
        int n = points.length;
        if (n < 3) return 0;
        if (memo[start][end] != 0) return memo[start][end];
        if (n == 3)
            return points[0] * points[1] * points[2];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            ans = Math.min(ans, points[0] * points[n - 1] * points[i]
                    + reconstruct(Arrays.copyOf(points, i + 1), start, start + i + 1)
                    + reconstruct(Arrays.copyOfRange(points, i, n), start + i, start + n));
        }
        memo[start][end] = ans;
        return ans;
    }

    public int minScoreTriangulation(int[] points) {
        int[][] dp = new int[50][50];
        int n = points.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j],
                            dp[i][k] + points[i] * points[k] * points[j] + dp[k][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
