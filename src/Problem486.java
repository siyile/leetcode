public class Problem486 {
    public boolean PredictTheWinner2(int[] nums) {
        return winner(nums, 0, nums.length - 1, 1) >= 0;
    }

    private int winner(int[] nums, int s, int e, int turn) {
        if (s == e) return turn * nums[s];
        int a = turn * nums[s] + winner(nums, s + 1, e, -turn);
        int b = turn * nums[e] + winner(nums, s, e - 1, -turn);
        return turn * Math.max(turn * a, turn * b);
    }

    public boolean PredictTheWinner1(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return winner(nums, 0, nums.length - 1, memo) >= 0;
    }

    private int winner(int[] nums, int s, int e, Integer[][] memo) {
        if (s == e)
            return nums[s];
        if (memo[s][e] != null)
            return memo[s][e];
        int a = nums[s] - winner(nums, s + 1, e, memo);
        int b = nums[e] - winner(nums, s, e - 1, memo);
        memo[s][e] = Math.max(a, b);
        return memo[s][e];
    }

    public boolean PredictTheWinner3(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            for (int s = 0; s + i < n; s++) {
                int e = s + i;
                dp[s][e] = Math.max(nums[s] - dp[s + 1][e], nums[e] - dp[s][e - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        System.arraycopy(nums, 0, dp, 0, n);
        for (int i = 1; i < n; i++) {
            for (int s = 0; s + i < n; s++) {
                int e = s + i;
                dp[s] = Math.max(nums[s] - dp[s + 1], nums[e] - dp[s]);
            }
        }
        return dp[0] >= 0;
    }
}
