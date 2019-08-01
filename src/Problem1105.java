public class Problem1105 {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= books.length; i++) {
            dp[i] = dp[i - 1] + books[i - 1][1];
            int height = books[i - 1][1];
            int width = books[i - 1][0];
            for (int j = i - 1; j > 0 && width + books[j - 1][0] <= shelf_width; j--) {
                width += books[j - 1][0];
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[books.length];
    }
}
