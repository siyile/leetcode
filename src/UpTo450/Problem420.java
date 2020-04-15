package UpTo450;

public class Problem420 {
    public int strongPasswordChecker(String s) {
        int res = 0, a = 1, A = 1, d = 1;
        char[] chs = s.toCharArray();
        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length();) {
            if (Character.isDigit(chs[i])) d = 0;
            if (Character.isLowerCase(chs[i])) a = 0;
            if (Character.isUpperCase(chs[i])) A = 0;

            int j = i;
            while (i < chs.length && chs[i] == chs[j]) {
                i++;
            }
            arr[j] = i - j;
        }
        int totalMissing = a + A + d;

        if (s.length() < 6) {
            return Math.max(0, 6 - (arr.length + totalMissing)) + totalMissing;
        } else {
            int overLength = Math.max(arr.length - 20, 0), leftOver = 0;
            res += overLength;

            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < s.length() && overLength > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != k - 1) continue;
                    arr[i] -= Math.min(overLength, k);
                    overLength -= k;
                }
            }

            for (int i = 0; i < s.length(); i++) {
                if (arr[i] >= 3 && overLength > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= overLength;
                    overLength -= need;
                }

                if (arr[i] >= 3) {
                    leftOver += arr[i] / 3;
                }
            }

            res += Math.max(leftOver, totalMissing);
            return res;
        }
    }

    public static void main(String[] args) {
        Problem420 p = new Problem420();

        System.out.println(p.strongPasswordChecker("1234567890123456Baaaa"));
    }
}
