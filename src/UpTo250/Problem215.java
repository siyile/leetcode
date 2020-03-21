package UpTo250;

public class Problem215 {
    public static void main(String[] args) {
        Problem215 p = new Problem215();

        System.out.println(p.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] > pivot)
                swap(nums, i++, j);
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findKthLargest(int[] nums, int k) {
        k--;
        int l = 0, r = nums.length - 1;
        while (true) {
            int m = partition(nums, l, r);
            if (m > k)
                r = m - 1;
            else if (m < k)
                l = m + 1;
            else
                return nums[k];
        }
    }
}
