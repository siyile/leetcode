package UpTo950;

import java.util.Arrays;

public class Problem912 {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) >> 1;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    private void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(a, l, L, 0, n1);
        System.arraycopy(a, m + 1, R, 0, n2);
        int i = 0, j = 0, cur = l;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                a[cur++] = L[i++];
            } else {
                a[cur++] = R[j++];
            }
        }
        if (i == n1) {
            while (j < n2) {
                a[cur++] = R[j++];
            }
        } else {
            while (i < n1) {
                a[cur++] = L[i++];
            }
        }
    }


    public static void main(String[] args) {
        Problem912 p = new Problem912();
        Arrays.stream(p.sortArray(new int[]{3,4,5,2,1})).forEach(System.out::println);
    }
}
