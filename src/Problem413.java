public class Problem413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int len = 1, diff = A[1] - A[0];
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] - A[i - 1] == diff) {
                len += 1;
            } else {
                if (len >= 3) {
                    ans += (1 + len - 2) * (len - 2) / 2;
                }
                diff = A[i] - A[i - 1];
                diff++;
                len = 1;
            }
        }
        if (len >= 3) {
            ans += (1 + len - 2) * (len - 2) / 2;
        }
        return ans;
    }
}
