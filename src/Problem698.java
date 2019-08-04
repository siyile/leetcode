import java.util.Arrays;

public class Problem698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num :
                nums) {
            sum += num;
        }
        if (sum % k > 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (target == nums[row]) {
            row--;
            k--;
        }
        return search(nums, row, new int[k], target);
    }

    private boolean search(int[] nums, int row, int[] group, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < group.length; i++) {
            if (group[i] + v <= target) {
                group[i] += v;
                if (search(nums, row, group, target))
                    return true;
                group[i] -= v;
            }
            if (group[i] == 0)
                break;
        }
        return false;
    }
}
