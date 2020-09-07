package UpTo750;

import java.util.Arrays;

public class Problem719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1];
        while (l < r) {
            int m = (l + r) / 2;
            int cnt = count(nums, m);
            if (cnt >= k)
                r = m - 1;
            else
                l = m;
        }
        return l;
    }

    private int count(int[] nums, int x) {
        int l = 0, cnt = 0;
        for (int r = 0; r < nums.length; r++) {
            while (nums[r] - nums[l] > x)
                l++;
            cnt += r - l;
        }
        return cnt;
    }
}
