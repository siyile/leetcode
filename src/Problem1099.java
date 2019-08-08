import java.util.Arrays;

public class Problem1099 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        if (A.length < 2 || A[0] + A[1] >= K) return -1;
        int ans = -1;
        while (l < r) {
            if (A[l] + A[r] < K) {
                l++;
                ans = Math.max(ans, A[l] + A[r]);
            } else {
                r--;
            }
        }
        return ans;
    }
}
