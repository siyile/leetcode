package UpTo350;

public class Problem343 {
    public int integerBreak(int n) {
        if (n == 3) return 2;
        int max = 1;
        for (int i = 2; i < n - 1; i++) {
            int prod = 1;
            int remainder = n % i;
            int quotient = n / i;
            for (int j = 0; j < i; j++) {
                if (j < remainder) {
                    prod *= quotient + 1;
                } else {
                    prod *= quotient;
                }
            }
            max = Math.max(max, prod);
        }
        return max;
    }
}
