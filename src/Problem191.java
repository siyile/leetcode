public class Problem191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n & 1;
            cnt >>>= 1;
        }
        return cnt;
    }
}
