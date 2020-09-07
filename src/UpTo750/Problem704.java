package UpTo750;

public class Problem704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l - (l - r) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return -1;
    }
}
