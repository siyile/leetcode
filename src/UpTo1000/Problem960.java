package UpTo1000;

import java.util.Arrays;

public class Problem960 {
    public int minDeletionSize(String[] A) {
        int n = A[0].length(), m = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int k = 0;
                for (; k < m; k++) {
                    if (A[k].charAt(i) < A[k].charAt(j)) {
                        break;
                    }
                }
                if (k == m) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return n - Arrays.stream(dp).max().getAsInt();
    }
}
