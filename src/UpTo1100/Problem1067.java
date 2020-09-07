package UpTo1100;

public class Problem1067 {
    public static void main(String[] args) {
        Problem1067 p = new Problem1067();

        System.out.println(p.digitsCount(0, 100, 250));
    }

    public int digitsCount(int d, int low, int high) {
        return digitsCount(d, high) - digitsCount(d, low - 1);
    }

    private int digitsCount(int d, int n) {
        int cnt = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            cnt += (a + 9 - d) / 10 * m + (a % 10 == d ? b + 1 : 0);
            if (d == 0) cnt -= m;
        }

        return cnt;
    }
}
