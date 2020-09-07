package UpTo900;

public class Problem878 {
    public int nthMagicalNumber(int N, int A, int B) {
        int MODULES = 1_000_000_007;
        long l = 0, r = 1_000_000_000L * 40_000L;
        while (l < r) {
            long m = (r - l) / 2 + l;
            if (enough(A, B, N, m))
                r = m;
            else
                l = m + 1;
        }
        return (int) l % MODULES;
    }

    private boolean enough(int a, int b, int n, long x) {
        return x / a + x / b + x / lcm(a, b) >= n;
    }

    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
