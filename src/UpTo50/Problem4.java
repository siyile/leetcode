package UpTo50;

public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length, n = nums2.length;

        int half = (m + n + 1) / 2;
        int l = 0, r = m;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = half - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                r = i - 1;
            } else if (i < m && nums2[j - 1] > nums1[i]) {
                l = i + 1;
            } else {
                double maxLeft = 0;
                if (i == 0)
                    maxLeft = nums2[j - 1];
                else if (j == 0)
                    maxLeft = nums1[i - 1];
                else
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                if ((m + n) % 2 == 1) return maxLeft;

                double minRight = 0;
                if (i == m)
                    minRight = nums2[j];
                else if (j == n)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight) / 2;
            }
        }

        return 0;
    }
}
