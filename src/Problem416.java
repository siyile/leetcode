import java.util.Arrays;

public class Problem416 {
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        int K = 2;
        for (int num :
                nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int[] group = new int[K];
        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) {
            return false;
        }
        return search(group, target, nums, row);
    }

    private boolean search(int[] group, int target, int[] nums, int row) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < group.length; i++) {
            if (group[i] + v <= target) {
                group[i] += v;
                if (search(group, target, nums, row))
                    return true;
                group[i] -= v;
            }
            if (group[i] == 0) break;
        }
        return false;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num :
                nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        Arrays.sort(nums);
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j < target + 1; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = (dp[i][j] || dp[i + 1][j - nums[i]]);
                }
            }
        }
        return dp[0][target];
    }
}
