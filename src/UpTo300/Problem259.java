package UpTo300;

import java.util.Arrays;

public class Problem259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 2; i++) {
            int right = len - 1, left = i + 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
