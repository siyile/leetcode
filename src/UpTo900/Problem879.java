package UpTo900;

public class Problem879 {
    long mod = 1_000_000_007;

    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        long[][] dp = new long[101][101];
        dp[0][0] = 1;
        long ans = 0;
        for (int i = 0; i < group.length; i++) {
            for (int g = G; g >= group[i]; g--) {
                for (int p = P; p >= 0; p--) {
                    dp[g][p] = (dp[g - group[i]][Math.max(p - profit[i], 0)] + dp[g][p]) % mod;
                }
            }
        }

        for (int i = 0; i <= G; i++) {
            ans = (ans + dp[i][P]) % mod;
        }
        return (int) ans;
    }
}
