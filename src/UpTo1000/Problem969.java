package UpTo1000;

import java.util.ArrayList;
import java.util.List;

public class Problem969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();
        for (int i = A.length; i > 1; i--) {
            int max = A[0];
            int maxIndex = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] > max) {
                    max = A[j];
                    maxIndex = j;
                }
            }
            reverse(A, maxIndex + 1);
            ans.add(maxIndex + 1);
            reverse(A, i);
            ans.add(i);
        }
        return ans;
    }

    private void reverse(int[] a, int k) {
        for (int i = 0; i < k / 2; i++) {
            swap(a, i, k - i - 1);
        }
    }

    private void swap(int[] a, int x, int y) {
        int tmp = a[y];
        a[y] = a[x];
        a[x] = tmp;
    }
}
