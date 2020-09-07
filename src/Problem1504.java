import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem1504 {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] h = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                h[j] = mat[i][j] == 0 ? 0 : 1 + h[j];
            }
            res += helper(h);
        }
        return res;
    }

    private int helper(int[] h) {
        int[] sum = new int[h.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < h.length; i++) {
            int prev = -1;
            while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                prev = stack.poll();
            }
            if (stack.isEmpty()) {
                sum[i] = (i + 1) * h[i];
            } else {
                sum[i] = (i - prev) * h[i] + sum[prev];
            }
            stack.push(i);
        }

        return Arrays.stream(sum).sum();
    }
}
