package UpTo400;

import java.util.TreeSet;

public class Problem363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++) {
            int[] sum = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    sum[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int curSum = 0;
                for (int s :
                        sum) {
                    curSum += s;
                    Integer num = set.ceiling(curSum - k);
                    if (num != null) {
                        ans = Math.max(ans, curSum - num);
                    }
                    set.add(curSum);
                }
            }
        }
        return ans;
    }
}
