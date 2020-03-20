public class Problem276 {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        int same = 0, notSame = k;
        for (int i = 1; i < n; i++) {
            int tmp = same;
            same = notSame;
            notSame = (k - 1) * (tmp + notSame);
        }
        return notSame + same;
    }
}
