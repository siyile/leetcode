package UpTo50;

import java.util.Arrays;

public class Problem31 {
    public static void main(String[] args) {
        Problem31 p = new Problem31();
        int[] nums = {1};
        p.nextPermutation(nums);
        for (Integer x : nums) {
            System.out.println(x);
        }
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        int max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            int value = nums[i];
            if (value <= max) {
                for (int j = len - 1; j > i; j--) {
                    if (value < nums[j]) {
                        swap(nums, i, j);
                        Arrays.sort(nums, i + 1, len);
                        return;
                    }
                }
            } else {
                max = value;
            }
        }
        Arrays.sort(nums);
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
