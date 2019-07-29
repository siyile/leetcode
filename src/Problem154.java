public class Problem154 {
    public static void main(String[] args) {
        Problem154 p = new Problem154();

        System.out.println(p.findMin(new int[]{3, 3, 1, 3}));
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] < nums[r])
                return nums[l];
            int mid = (l + r) / 2;
            if (nums[r] < nums[mid]) {
                l = mid + 1;
            } else if (nums[mid] < nums[l]) {
                r = mid;
            } else if (nums[r] == nums[l]) {
                int temp = mid;
                while (temp < r - 1 && nums[temp] == nums[r])
                    temp = (temp + r) / 2;
                if (temp == r - 1 && nums[temp] == nums[r]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
        }
        return nums[l];
    }
}
