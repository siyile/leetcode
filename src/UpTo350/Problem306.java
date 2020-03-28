package UpTo350;

public class Problem306 {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length() - 1 && i <= 12; i++) {
            long x = stringToDigit(0, i, num);
            if (x != -1) {
                for (int j = i + 1; j < num.length() && j <= i + 12; j++) {
                    long y = stringToDigit(i, j, num);
                    if (y != -1 && validate(j, num, x, y))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean validate(int start, String s, long x, long y) {
        if (start == s.length()) return true;
        int num = 1;
        long target = x + y;
        while (target >= 10) {
            target /= 10;
            num++;
        }
        if (start + num > s.length()) {
            return false;
        } else {
            long z = stringToDigit(start, start + num, s);
            if (z == -1 || z != x + y) return false;
            return validate(start + num, s, y, x + y);
        }
    }

    private long stringToDigit(int l, int r, String s) {
        long sum = 0;
        for (int i = l; i < r; i++) {
            sum = sum * 10 + s.charAt(i) - '0';
        }
        if (sum == 0 && r - l > 1 || sum != 0 && s.charAt(l) == '0') {
            return -1;
        } else {
            return sum;
        }
    }

    public static void main(String[] args) {
        Problem306 p = new Problem306();

        System.out.println(p.isAdditiveNumber("123"));
    }
}
