package UpTo150;

public class Problem121 {
    public static void main(String[] args) {
        Problem121 p = new Problem121();
        int[] a = {7, 6, 4, 3, 1};
        System.out.println(p.maxProfit(a));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[] diff = new int[prices.length - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        int max = 0;
        int cur = 0;
        for (int i = 0; i < diff.length; i++) {
            if (cur < 0) {
                cur = 0;
            }
            if (cur + diff[i] > max) {
                max = cur + diff[i];
                cur = max;
            } else {
                cur = cur + diff[i];
            }
        }
        return max;
    }
}
