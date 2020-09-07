package UpTo900;

import java.util.Arrays;

public class Problem891 {
    int mod = 1_000_000_007;

    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        long ans = 0, mult = 1;
        for (int i = 1; i < A.length; i++) {
            ans = (ans + A[i] * mult) % mod;
            mult = (2 * mult) % mod;
        }
        mult = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            ans = (ans - A[i] * mult) % mod;
            mult = (2 * mult) % mod;
        }
        return (int) ((ans + mod) % mod);
    }
}
