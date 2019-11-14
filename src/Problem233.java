public class Problem233 {
    public int countDigitOne(int n) {
        int cnt = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divide = i * 10;
            cnt += n / divide + Math.min(Math.max(n % divide + i - 1, 0), 10);
        }
        return cnt;
    }
}
