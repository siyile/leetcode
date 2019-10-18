public class Problem837 {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || K + W - 1 < N) return 1;
        double[] dp = new double[N + 1];
        double sumW = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = sumW / W;
            if (i < K) sumW += dp[i];
            else res += dp[i];
            if (i >= W) sumW -= dp[i - W];
        }

        return res;
    }
}
