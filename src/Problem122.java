public class Problem122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Problem122 p = new Problem122();
        int[] a = {7,6,4,3,1};
        System.out.println(p.maxProfit(a));
    }
}
