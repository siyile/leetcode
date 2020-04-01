public class Problem357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10, available = 9, uniqueDigit = 9;
        while (n-- > 1 && available > 0) {
            uniqueDigit *= available--;
            res += uniqueDigit;
        }

        return res;
    }
}
