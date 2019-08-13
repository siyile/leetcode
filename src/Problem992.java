public class Problem992 {
    public static void main(String[] args) {
        Problem992 p = new Problem992();

        System.out.println(p.subarraysWithKDistinct(new int[]{2, 2, 1, 2, 2, 2, 1, 1}, 2));
    }

    public int subarraysWithKDistinct1(int[] A, int K) {
        int[] memo = new int[A.length + 1];
        int cnt = 0, prefix = 0;
        int ans = 0;
        for (int l = 0, r = 0; r < A.length; r++) {
            if (memo[A[r]]++ == 0)
                cnt++;
            if (cnt > K) {
                prefix = 0;
                memo[A[l++]]--;
                cnt--;
            }
            while (memo[A[l]] > 1) {
                memo[A[l++]]--;
                prefix++;
            }
            if (cnt == K) {
                ans += prefix + 1;
            }
        }
        return ans;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    public int atMostK(int[] A, int K) {
        int[] memo = new int[A.length + 1];
        int l = 0, cnt = 0;
        int ans = 0;
        for (int r = 0; r < A.length; r++) {
            if (memo[A[r]]++ == 0)
                cnt++;
            while (cnt > K) {
                if (--memo[A[l++]] == 0)
                    cnt--;
            }
            ans += r - l;
        }
        return ans;
    }
}
