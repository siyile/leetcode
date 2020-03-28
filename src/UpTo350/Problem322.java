package UpTo350;

import java.util.Arrays;

public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            if (dp[i] == 1) continue;
            for (int coin :
                    coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin], dp[i]);
                }
            }

            if (dp[i] != Integer.MAX_VALUE) dp[i]++;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
