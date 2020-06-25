public class Problem902 {
    public int atMostNGivenDigitSet(String[] D, int N) {
        String s = String.valueOf(N);
        int ans = 0;
        int d = s.length();
        for (int i = 1; i < d; i++) {
            ans += Math.pow(D.length, i);
        }

        for (int i = 0; i < s.length(); i++) {
            boolean same = false;
            for (String value : D) {
                if (value.charAt(0) < s.charAt(i)) {
                    ans += Math.pow(D.length, d - i - 1);
                } else if (value.charAt(0) == s.charAt(i)) {
                    same = true;
                }
            }
            if (!same) {
                return ans;
            }
        }
        return ans + 1;
    }
}
