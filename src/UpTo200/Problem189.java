package UpTo200;

public class Problem189 {
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int cnt = 0;
        for (int start = 0; cnt < n; start++) {
            int cur = start;
            int prev = nums[cur];
            do {
                int next = (cur + k) % n;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                cur = next;
                cnt++;
            } while (cur != start);
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}
