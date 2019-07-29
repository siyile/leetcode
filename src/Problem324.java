public class Problem324 {
    private int n;

    public void wiggleSort(int[] nums) {
        int mid = findKthLargest(nums, nums.length / 2);
        n = nums.length - 1;
        int l = 0, i = 0, r = nums.length - 1;
        while (i < r) {
            if (mid < mapIndex(i)) {
                swap(nums, mapIndex(i++), mapIndex(l++));
            } else if (mid > mapIndex(i)) {
                swap(nums, mapIndex(i), mapIndex(r--));
            } else
                i++;
        }
    }

    private int mapIndex(int x) {
        return (1 + 2 * x) % (n | 1);
    }

    private int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (true) {
            int pivot = partition(nums, l, r);
            if (pivot > k) {
                r = pivot - 1;
            } else if (pivot < k) {
                l = pivot + 1;
            } else {
                return nums[pivot];
            }
        }
    }

    private int partition(int[] nums, int l, int r) {
        int i = l;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] > nums[r]) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
