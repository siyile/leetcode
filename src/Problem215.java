public class Problem215 {
    private int partition(int left, int right, int[] array) {
        int pivotIndex = left + (right - left) / 2;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);

        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] >= pivot) {
                leftBound++;
            } else if (array[rightBound] < pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (true) {
            int pivot = partition(l, r, nums);
            if (pivot == k - 1) {
                return nums[pivot];
            } else if (pivot > k - 1) {
                r = pivot - 1;
            } else {
                l = pivot + 1;
            }
        }
    }
}
