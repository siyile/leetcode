package UpTo400;

import java.util.Arrays;

public class Problem354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[envelopes.length];
        int j = 1;
        dp[0] = envelopes[0][1];
        for (int i = 1; i < envelopes.length; i++) {
            int k = Arrays.binarySearch(dp, 0, j, envelopes[i][1]);
            if (k >= 0) {
                continue;
            }
            k = ~k;
            if (j == k) {
                dp[j++] = envelopes[i][1];
            } else {
                dp[k] = envelopes[i][1];
            }
        }

        return j;
    }
}
