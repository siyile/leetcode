package UpTo350;

public class Problem312 {
    public int maxCoins(int[] nums) {
        int[] A = new int[nums.length + 2];
        int n = A.length;
        for (int i = 0; i < nums.length; i++) {
            A[i + 1] = nums[i];
        }
        A[0] = A[n - 1] = 1;
        int[][] dp = new int[n][n];
        for (int left = n - 3; left >= 0; left--) {
            for (int right = left + 2; right < n; right++) {
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][i] + dp[i][right] + A[left] * A[right] * A[i]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
