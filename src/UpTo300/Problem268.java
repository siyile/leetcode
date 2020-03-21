package UpTo300;

public class Problem268 {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - 1) != nums.length) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        return nums.length;
    }
}
