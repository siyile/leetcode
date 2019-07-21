package UpTo50;

public class Problem50 {
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        double ans = 1;
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                ans = x;
            } else {
                n = -n;
            }
        }

        int count = 0;
        int cur = 1;
        while (cur <= n && count < 30) {
            count++;
            cur *= 2;
        }
        if (cur > n) {
            cur /= 2;
            count--;
        }
        boolean[] mutiply = new boolean[count + 1];
        while (cur > 0) {
            if (cur <= n) {
                mutiply[count] = true;
                n -= cur;
            }
            cur /= 2;
            count--;
        }
        double base = x;
        for (int i = 0; i <mutiply.length; i++) {
            if (mutiply[i]) {
                ans *= base;
            }
            base *= base;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double tmp = myPow(x * x, n / 2);
        if (n % 2 == 1)
            return x * tmp * tmp;
        else return tmp * tmp;
    }

    public static void main(String[] args) {
        Problem50 p = new Problem50();
        double x = 2;
        int n = -2;
        System.out.println((p.myPow(x,n) - Math.pow(x, n)));
    }
}
