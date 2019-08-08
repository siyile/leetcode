public class Problem1144 {
    public int movesToMakeZigzag(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i - 1 >= 0 ? nums[i - 1] : 1001;
            int right = i + 1 < nums.length ? nums[i + 1] : 1001;
            res[i % 2] += Math.min(left, right) - nums[i] + 1;
        }
        return Math.min(res[0], res[1]);
    }
}
