package UpTo750;

public class Problem713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int l = 0;
        int prod = 1;
        int cnt = 0;
        for (int r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (prod >= k) prod /= nums[l];
            cnt += r - l + 1;

        }
        return cnt;
    }
}
