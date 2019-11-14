import java.util.Arrays;

public class Problem977 {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] ans = new int[n];

        int r;
        for (r = 0; r < n && A[r] < 0; r++) {}

        int l = r - 1;

        int i = 0;
        while (l >= 0 && r < n) {
            if (-A[l] > A[r]) {
                ans[i] = A[r] * A[r];
                r++;
            } else {
                ans[i] = A[l] * A[l];
                l--;
            }
            i++;
        }

        while (l >= 0) {
            ans[i++] = A[l] * A[l--];
        }

        while (r < n) {
            ans[i++] = A[r] * A[r++];
        }

        return ans;
    }
}
