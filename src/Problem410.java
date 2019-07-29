public class Problem410 {
    public int splitArray2(int[] nums, int m) {
        int[][] memo = new int[nums.length + 1][m + 1];
        int[] sub = new int[nums.length + 1];

        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= m; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }
        memo[0][0] = 0;

        for (int i = 0; i < nums.length; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    memo[i][j] = Math.min(memo[i][j], Math.max(memo[k][j - 1], sub[i] - sub[k]));
                }
            }
        }

        return memo[nums.length][m];
    }

    public int splitArray(int[] nums, int m) {
        long l = 0;
        long r = 0;
        for (int num :
                nums) {
            r += num;
            if (l < num) l = num;
        }

        while (l < r) {
            long mid = (l + r) >> 2;
            if (!check(nums, m, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int) l;
    }

    private boolean check(int[] nums, int m, long x) {
        int cnt = 1, sum = 0;
        for (int num :
                nums) {
            if (num + sum > x) {
                cnt++;
                sum = 0;
            }
            sum += num;
        }
        return m >= cnt;
    }
}
