package UpTo350;

public class Problem342 {
    public boolean isPowerOfFour(int num) {
        if (num == 1) {
            return true;
        }
        return num >= 0 && num % 4 == 0 && isPowerOfFour(num / 4);
    }
}
