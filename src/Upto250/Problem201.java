package Upto250;

public class Problem201 {
    public int rangeBitwiseAnd(int m, int n) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if ((n >> i & 1) == 1 && (m >> i & 1) == 1 && n - m < (1 << i)) {
                ans += (1 << i);
            }
        }
        return ans;
    }
}
