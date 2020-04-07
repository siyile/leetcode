package UpTo400;

public class Problem397 {
    public int integerReplacement(int n) {
        int res = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || (n >>> 1 & 1) == 0) {
                n -= 1;
            } else {
                n += 1;
            }
            res++;
        }
        return res;
    }
}
