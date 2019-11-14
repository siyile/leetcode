package UpTo200;

public class Problem162 {
    public static void main(String[] args) {
        Problem162 p = new Problem162();

        System.out.println(p.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] > nums[l + 1]) return nums[l];
            if (nums[r] > nums[r - 1]) return nums[r - 1];
            l = l + 1;
            r = r - 1;
            while (l < r) {
                int m = l - (l - r) / 2;
                if (nums[m] > nums[m + 1] && nums[m] > nums[m - 1]) {
                    return nums[m];
                } else if (nums[m] < nums[m + 1]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return nums[l];
    }
}
