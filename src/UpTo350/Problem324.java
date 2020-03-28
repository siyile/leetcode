package UpTo350;

public class Problem324 {
    private int n;

    public static void main(String[] args) {
        Problem324 p = new Problem324();
        p.wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
    }

    public void wiggleSort(int[] nums) {
        this.n = nums.length;
        int median = findKthLargest(nums, n / 2);
        System.out.println(median);
        int i = 0, k = n - 1, j = 0;
        while (j <= k) {
            if (nums[index(j)] > median) {
                swap(nums, index(i++), index(j++));
            } else if (nums[index(j)] < median) {
                swap(nums, index(k--), index(j));
            } else {
                j++;
            }
        }
    }

    private int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (true) {
            int pivot = nums[r];
            int left = l;
            for (int i = l; i < r; i++) {
                if (nums[i] > pivot) {
                    swap(nums, left++, i);
                }
            }
            swap(nums, left, r);
            if (left < k)
                l = left + 1;
            else if (left > k) {
                r = left - 1;
            } else {
                return nums[k];
            }
        }
    }

    private int index(int i) {
        return (2 * i + 1) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
