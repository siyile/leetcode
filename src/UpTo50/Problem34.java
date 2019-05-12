package UpTo50;

public class Problem34 {
    public int[] searchRange1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            int[] ans = {-1, -1};
            return ans;
        }
        int low = 0;
        int high = len - 1;
        int mid;
        int midIndex = -1;
        while (low <= high) {
            midIndex = (low + high) / 2;
            mid = nums[midIndex];
            if (mid == target) {
                break;
            }
            if (mid < target) {
                low = midIndex + 1;
            }
            else {
                high = midIndex - 1;
            }
        }
        if (nums[midIndex] != target) {
            int[] ans = {-1, -1};
            return ans;
        }
        high = midIndex;
        low = midIndex;
        while (++high < len && nums[high] == target) {}
        while (--low > -1 && nums[low] == target) {}
        int[] ans = {low + 1, high - 1};
        return ans;
    }

    public int emtremeSearch(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target || left && (nums[mid] == target)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int leftIndex = emtremeSearch(nums, target, true);

        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return ans;
        }

        int rightIndex = emtremeSearch(nums, target, false);
        ans[0] = leftIndex;
        ans[1] = rightIndex - 1;
        return ans;
    }

    public static void main(String[] args) {
        Problem34 p = new Problem34();
        int[] b = {1};
        int[] a = p.searchRange(b, 1);
        for (Integer x: a) {
            System.out.println(x);
        }
    }
}
