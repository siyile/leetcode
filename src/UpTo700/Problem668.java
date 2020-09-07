package UpTo700;

public class Problem668 {
    public static void main(String[] args) {
        Problem668 p = new Problem668();

        System.out.println(p.findKthNumber(2, 3, 6));
    }

    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mi = (r - l) / 2 + l;
            int cnt = count(mi, m, n);
            if (cnt >= k)
                r = mi;
            else
                l = mi + 1;
        }
        return l;
    }

    public int count(int x, int m, int n) {
        int cnt = 0;
        for (int i = 1; i <= x && i <= m; i++) cnt += Math.min(x / i, n);
        return cnt;
    }
}
