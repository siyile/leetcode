package UpTo300;

public class Problem258 {
    public int addDigits(int num) {
        while (num >= 10) {
            int n = 0;
            while (num > 0) {
                n += num % 10;
                num /= 10;
            }
            num = n;
        }
        return num;
    }
}
