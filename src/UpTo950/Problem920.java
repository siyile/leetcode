package UpTo950;

public class Problem920 {
    public int numMusicPlaylists(int N, int L, int K) {
        int mod = 1_000_000_007;
        long[][] dp = new long[101][101];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N && j <= i; j++) {
                // case 1: get new song
                dp[i][j] = dp[i - 1][j - 1] * (N - j + 1);
                // case 2: get old song
                if (j > K) {
                    dp[i][j] += dp[i-1][j] * (j - K);
                }
                dp[i][j] %= mod;
            }
        }
        return (int) dp[L][N];
    }
}
