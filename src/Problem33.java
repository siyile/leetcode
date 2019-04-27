import java.util.Arrays;

public class Problem33 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        return recursiveSearch(nums, target, 0, len - 1);
    }

    public int recursiveSearch(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex == nums.length) return -1;
        int start = nums[startIndex];
        int centerIndex = (endIndex + startIndex) / 2;
        int center = nums[centerIndex];
        if (target == center) return centerIndex;
        if (target == start) return startIndex;

        int len = endIndex - startIndex;
        if (len < 0) return -1;

        if (start > center) {
            if (target > start || target < center) {
                return recursiveSearch(nums, target, startIndex + 1, centerIndex - 1);
            }
            else {
                return recursiveSearch(nums, target, centerIndex + 1, endIndex);
            }
        }
        else {
            if (target > center || target < start) {
                return recursiveSearch(nums, target, centerIndex + 1, endIndex);
            }
            else {
                return recursiveSearch(nums, target, startIndex + 1, centerIndex - 1);
            }
        }
    }

    public static void main(String[] args) {
        Problem33 p = new Problem33();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 4;
        System.out.println(p.search(nums, target));
    }
}
