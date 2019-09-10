package UpTo50;

public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int len1 = nums1.length, len2 = nums2.length, halfLen = (len1 + len2 + 1) / 2;

        int l = 0, r = len1;
        while (true) {
            int aCount = (r - l) / 2 + l;
            int bCount = halfLen - aCount;
            if (aCount > 0 && nums1[aCount - 1] > nums2[bCount])
                r = aCount - 1;
            else if (aCount < len1 && nums2[bCount - 1] > nums1[aCount])
                l = aCount + 1;
            else {
                int leftHalfMax = aCount == 0 ? nums2[bCount - 1] :
                        bCount == 0 ? nums1[aCount - 1] :
                                Math.max(nums1[aCount - 1], nums2[bCount - 1]);
                if (odd(len1, len2)) return leftHalfMax;
                int rightHalfMin = aCount == len1 ? nums2[bCount] :
                        bCount == len2 ? nums1[aCount] :
                                Math.min(nums1[aCount], nums2[bCount]);
                return (leftHalfMax + rightHalfMin) / 2.0;
            }
        }
    }

    private boolean odd(int len1, int len2) {
        return ((len1 + len2) & 1) == 1;
    }
}
