package UpTo250;

public class Problem213 {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int start, int end) {
        int rob = 0;
        int noRob = 0;
        for (int i = start; i < end; i++) {
            int tmp = noRob + nums[i];
            noRob = Math.max(noRob, rob);
            rob = tmp;
        }
        return Math.max(rob, noRob);
    }
}
