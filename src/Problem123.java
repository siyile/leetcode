public class Problem123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minValue = prices[0];
        int maxProfit = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - minValue > maxProfit) {
                maxProfit = prices[i] - minValue;
                end = i;
                start = tempStart;
            }
            if (prices[i] < minValue) {
                minValue = prices[i];
                tempStart = i;
            }
        }
        return maxProfit + Math.max(maxProfitPart(prices, 0, start), maxProfitPart(prices, end, prices.length));
    }

    private int maxProfitPart(int[] prices, int start, int end) {
        int minValue = prices[start];
        int maxProfit = 0;
        for (int i = start; i < end; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Problem123 p = new Problem123();
        int[] a = {6,1,3,2,4,7};
        System.out.println(p.maxProfit(a));
    }
}
