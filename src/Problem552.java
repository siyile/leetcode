public class Problem552 {
    public int checkRecord(int n) {
        int MODULE = 1_000_000_007;
        int[] a = new int[n], p = new int[n], l = new int[n];
        a[0] = 1;
        p[0] = 1;
        l[0] = 1;
        a[1] = 2;
        p[1] = 3;
        l[1] = 3;
        a[2] = 4;
        p[2] = 8;
        l[2] = 7;
        for (int i = 3; i < n; i++) {
            p[i] = ((a[i - 1] + p[i - 1]) % MODULE + l[i - 1]) % MODULE;
            l[i] = (((a[i - 1] + p[i - 1]) % MODULE + a[i - 2]) % MODULE + p[i - 2]) % MODULE;
            a[i] = ((a[i - 1] + a[i - 2]) % MODULE + a[i - 3]) % MODULE;
        }

        return ((p[n - 1] + a[n - 1]) % MODULE + l[n - 1]) % MODULE;
    }
}
