package UpTo1500;

public class Problem1405 {
    private String longestDiverseString(int a, int b, int c, String aa, String bb, String cc) {
        if (b > a) {
            return longestDiverseString(b, a, c, bb, aa, cc);
        }
        if (c > b) {
            return longestDiverseString(a, c, b, aa, cc, bb);
        }
        if (b == 0) {
            return aa.repeat(Math.min(2, a));
        }
        int useA = Math.min(2, a);
        int useB = a - useA >= b ? 1 : 0;
        return aa.repeat(useA) + bb.repeat(useB) + longestDiverseString(a - useA, b - useB, c, aa, bb, cc);
    }

    public String longestDiverseString(int a, int b, int c) {
        return longestDiverseString(a, b, c, "a", "b", "c");
    }
}
