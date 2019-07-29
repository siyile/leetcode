public class Problem188 {
    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) {
            return quickSell(prices);
        }

        int[][] memo = new int[k + 1][prices.length];
        for (int i = 1; i <= k + 1; i++) {
            int tempMax = -prices[0];
            for (int j = 0; j < prices.length; j++) {
                memo[i][j] = Math.max(memo[i][j - 1], prices[j] + tempMax);
                tempMax = Math.max(tempMax, memo[i][j] - prices[j]);
            }
        }

        return memo[k + 1][prices.length - 1];
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
