package UpTo1100;

import java.util.HashMap;
import java.util.Map;

public class Problem1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                Map<Integer, Integer> cnt = new HashMap<>();
                cnt.put(0, 1);
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += matrix[k][j] - i > 0 ? matrix[k][i - 1] : 0;
                    ans += cnt.getOrDefault(sum - target, 0);
                    cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return ans;
    }
}
