package UpTo50;

public class Problem29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isSameSign = true;
        if (dividend > 0) {
            dividend = -dividend;
            isSameSign = !isSameSign;
        }
        if (divisor > 0) {
            divisor = -divisor;
            isSameSign = !isSameSign;
        }
        if (isSameSign) {
            return divideHelper(dividend, divisor);
        } else {
            return -divideHelper(dividend, divisor);
        }
    }

    public int divideHelper(int dividend, int divisor) {
        if (divisor < dividend) return 0;
        int cur = 0;
        int ans = divisor;
        int res;
        while (ans >= dividend && ans < 0 && cur < 31) {
            cur++;
            ans = divisor << cur;
        }
        res = dividend - (divisor << cur - 1);
        if (res > divisor) return 1 << cur - 1;
        return (1 << cur - 1) + divideHelper(res, divisor);
    }

    public static void main(String[] args) {
        Problem29 p = new Problem29();
        System.out.println(p.divide(10, 1));
    }
}
