package UpTo350;

public class Problem303 {
    private class NumArray {
        int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length + 1];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                prefixSum[i + 1] = sum;
            }
        }

        public int sumRange(int i, int j) {
            return prefixSum[j + 1] - prefixSum[i];
        }
    }
}
