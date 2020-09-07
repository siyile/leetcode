package UpTo1500;

import java.util.Arrays;

public class Problem1406 {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -99999999);
        dp[n] = 0;
        int[] sum = new int[n + 1];
        for (int i = stoneValue.length - 1; i >= 0; i--) {
            dp[i] = Math.max(sum[i + 1] - dp[i + 1] + stoneValue[i], dp[i]);
            if (i + 1 < n) {
                dp[i] = Math.max(sum[i + 2] - dp[i + 2] + stoneValue[i] + stoneValue[i + 1], dp[i]);
            }
            if (i + 2 < n) {
                dp[i] = Math.max(sum[i + 3] - dp[i + 3] + stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2], dp[i]);
            }
            sum[i] = stoneValue[i] + sum[i + 1];
        }

        if (dp[0] > sum[0] - dp[0]) {
            return "Alice";
        } else if (dp[0] < sum[0] - dp[0]) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public static void main(String[] args) {
        Problem1406 p = new Problem1406();

        System.out.println(p.stoneGameIII(new int[]{1,2,3,7}));
    }
}
