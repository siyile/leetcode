package UpTo200;

public class Problem153 {
    public static void main(String[] args) {
        Problem153 p = new Problem153();

        System.out.println(p.findMin(new int[]{4}));
    }

    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    public int find(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        int min;
        if (nums[mid] > nums[end])
            min = find(nums, mid + 1, end);
        else if (nums[start] > nums[mid])
            min = find(nums, start, mid - 1);
        else
            min = nums[start];
        return Math.min(nums[mid], min);
    }
}
