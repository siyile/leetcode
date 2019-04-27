public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        if (low - 1 > -1 && nums[low - 1] == target) {
            return low - 1;
        } else {
            return low;
        }
    }

    public static void main(String[] args) {
        Problem35 p = new Problem35();
        int[] b = {1, 2, 7, 9};
        System.out.println(p.searchInsert(b, 6));
    }
}
