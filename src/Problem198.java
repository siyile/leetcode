public class Problem198 {
    public static void main(String[] args) {
        Problem198 p = new Problem198();

        System.out.println(p.rob(new int[]{2, 7, 9, 3, 1}));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[][] memo = new int[n][2];
        memo[0][0] = 0;
        memo[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            memo[i][0] = Math.max(memo[i - 1][1], memo[i - 1][0]);
            memo[i][1] = nums[i] + memo[i - 1][0];
        }
        return Math.max(memo[n - 1][0], memo[n - 1][1]);
    }
}
