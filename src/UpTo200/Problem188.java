package UpTo200;

public class Problem188 {
    public static void main(String[] args) {
        Problem188 p = new Problem188();

        System.out.println(p.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    public int maxProfit(int K, int[] prices) {
        if (K / 2 >= prices.length) return quickSell(prices);
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[K + 1][n];
        int ans = 0;
        for (int k = 1; k < K + 1; k++) {
            int tmpMax = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                tmpMax = Math.max(dp[k - 1][i - 1] - prices[i - 1], tmpMax);
                dp[k][i] = Math.max(prices[i] + tmpMax, dp[k][i - 1]);
            }
        }
        return dp[K][n - 1];
    }

    public int quickSell(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i])
                ans += prices[i] - prices[i - 1];
        }
        return ans;
    }
}