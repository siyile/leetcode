public class Problem1035 {
    public int maxUncrossedLines(int[] a, int[] b) {
        int[][] dp = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[a.length - 1][b.length - 1];
    }
}
