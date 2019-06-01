package UpTo100;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        System.arraycopy(nums1, 0, nums1, n, m);
        int i = n, j = 0;
        int cur = 0;
        while (i < m + n && j < n) {
            if (nums1[i] < nums2[j]) {
                nums1[cur++] = nums1[i++];
            } else {
                nums1[cur++] = nums2[j++];
            }
        }
        while (i < m + n) {
            nums1[cur++] = nums1[i++];
        }
        while (j < n) {
            nums1[cur++] = nums2[j++];
        }
    }

    public static void main(String[] args) {
        Problem88 p = new Problem88();
        int[] a = {0,0,0};
        int[] b = {2,5,6};
        p.merge(a, 0, b, 3);
        System.out.println(Arrays.stream(a).mapToObj(x -> x + " ").collect(Collectors.joining()));
    }
}
