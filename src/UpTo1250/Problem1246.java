package UpTo1250;

import java.util.Arrays;

public class Problem1246 {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            Arrays.fill(dp[i], 100);
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 2;
        }
        for (int len = 3; len <= n; len++) {
            for (int left = 0, right = len - 1; right < n; left++, right++) {
                if (arr[left] == arr[right]) {
                    dp[left][right] = dp[left + 1][right - 1];
                }
                for (int mid = left; mid < right; mid++) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][mid] + dp[mid + 1][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
