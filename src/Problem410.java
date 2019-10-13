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
        // binarySearch
        int l = 1, r = Integer.MAX_VALUE;
        while (l < r) {
            // mi: middle
            int mi = (r - l) / 2 + l;
            // if true, middle is acceptable, set right to middle;
            if (possible(nums, m, mi))
                r = mi;
                // if false, middle is unacceptable, set left to middle + 1;
            else
                l = mi + 1;
        }
        return l;
    }

    // check whether suggested group sum is possible
    private boolean possible(int[] nums, int targetCnt, int targetSum) {
        // curSum: current group sum
        // set initial current group sum to sum for concise code
        int curSum = targetSum, groupNum = 0;
        for (int num :
                nums) {
            // if current num is bigger than target sum, failed anyway
            if (num > targetSum) return false;
            curSum += num;
            // if curSum bigger than target sum, groupNumber++ and set current sum to num
            if (curSum > targetSum) {
                curSum = num;
                groupNum++;
            }
            // fail if group number bigger than target group count
            if (groupNum > targetCnt) return false;
        }
        return true;
    }
}
