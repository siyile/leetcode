package UpTo400;

public class Problem376 {
    // greedy
    public int wiggleMaxLength1(int[] nums) {
        if (nums.length < 2) return nums.length;
        int len1 = 1, len2 = 1;
        boolean big1 = true, big2 = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (big1) {
                    len1++;
                    big1 = false;
                }
                if (big2) {
                    len2++;
                    big2 = false;
                }
            } else if (nums[i] < nums[i - 1]) {
                if (!big1) {
                    len1++;
                    big1 = true;
                }
                if (!big2) {
                    len2++;
                    big2 = true;
                }
            }
        }
        return Math.max(len1, len2);
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) down = up + 1;
            else if (nums[i] > nums[i - 1]) up = down + 1;
        }
        return Math.max(up, down);
    }
}
