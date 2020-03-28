package UpTo350;

public class Problem327 {
    int lower;
    int upper;
    int count = 0;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        long[] tmp = new long[nums.length + 1];
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        mergeSort(0, sum.length - 1, sum, tmp);
        return count;
    }
    
    private void mergeSort(int start, int end, long[] sum, long[] tmp) {
        if (end <= start) return;
        int mid = (start + end) / 2;
        mergeSort(start, mid, sum, tmp);
        mergeSort(mid + 1, end, sum, tmp);

        merge(start, end, sum, tmp);

        if (end + 1 - start >= 0) System.arraycopy(tmp, start, sum, start, end + 1 - start);
    }
    
    private void merge(int start, int end, long[] sum, long[] tmp) {
        int mid = (start + end) / 2;
        int index = start, right = mid + 1, high = mid + 1, low = mid + 1;
        for (int left = start; left <= mid; left++) {
            while (low <= end && sum[low] - sum[left] < lower) {
                low++;
            }
            while (high <= end && sum[high] - sum[left] <= upper) {
                high++;
            }

            // copy array
            while (right <= end && sum[right] < sum[left]) {
                tmp[index++] = sum[right++];
            }
            tmp[index++] = sum[left];

            count += high - low;
        }

        while (right <= end) {
            tmp[index++] = sum[right++];
        }
    }

    public static void main(String[] args) {
        Problem327 p = new Problem327();

        System.out.println(p.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
