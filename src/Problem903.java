import java.util.Arrays;

public class Problem903 {
    public int numPermsDISequence(String S) {
        int mod = 1_000_000_007;
        int n = S.length();
        int[][] dp = new int[n+1][n+1];
        n++;

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (S.charAt(i-1) == 'D') {
                long cur = 0;
                for (int j = n-i; j >= 0; j++) {
                    cur = (cur + dp[i-1][j+1]) % mod;
                    dp[i][j] = (int) cur;
                }
            } else {
                long cur = 0;
                for (int j = 1; j < n-i+1; j++) {
                    cur = (cur + dp[i-1][j]) % mod;
                    dp[i][j] = (int) cur;
                }
            }
        }
        return dp[n][0];
    }
}
