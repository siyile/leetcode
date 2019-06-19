public class Problem190 {
    // you need treat n as an unsigned value
    public int reverseBits2(int n) {
        int results = 0;
        for (int i = 0; i < 32; i++) {
            int end = n & 1;
            n >>= 1;
            results <<= 1;
            results |= end;
        }
        return results;
    }

    public int reverseBits(int n) {
        int ret = n;
        ret = ret >>> 16 | ret << 16;
        ret = (ret & 0xff00ff00) >>> 8 | (ret & 0x00ff00ff) << 8;
        ret = (ret & 0xf0f0f0f0) >>> 4 | (ret & 0x0f0f0f0f) << 4;
        ret = (ret & 0xcccccccc) >>> 2 | (ret & 0x33333333) << 2;
        ret = (ret & 0xaaaaaaaa) >>> 1 | (ret & 0x55555555) << 1;
        return ret;
    }

    public static void main(String[] args) {
        Problem190 p = new Problem190();
        System.out.println(p.reverseBits(-3));
    }
}
