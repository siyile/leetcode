package UpTo900;

public class Problem887 {
    public int superEggDrop(int K, int N) {
        int l = 0, r = N;
        while (l < r) {
            int m = (l + r) / 2;
            if (mostN(m, K, N) < N) {
                l = m + 1;
            } else
                r = m;
        }
        return l;
    }

    private int mostN(int x, int k, int n) {
        int r = 1, ans = 0;
        for (int i = 1; i <= k; i++) {
            r *= x - i + 1;
            r /= i;
            ans += r;
            if (ans > n) return ans;
        }
        return ans;
    }
}
