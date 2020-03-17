import java.util.HashSet;
import java.util.Set;

public class Problem1044 {
    static int MODULE = 1_000_000_007;
    static int a = 26;
    public String longestDupSubstring(String S) {
        int l = 0, r = S.length() - 1;
        while (l < r) {
            int mi = (l + r) / 2 + 1;
            if (search(S, mi) == -1) {
                r = mi - 1;
            } else {
                l = mi;
            }
        }

        if (l == 0) return "";
        int start = search(S, l);
        return S.substring(start, l + start);
    }

    public int search(String s, int len) {
        char[] chs = s.toCharArray();
        Set<Long> set = new HashSet<>();

        long aL = 1;
        for (int i = 0; i < len; i++) {
            aL *= a;
            aL %= MODULE;
        }

        long h = 0;
        for (int i = 0; i < len; i++) {
            h = (h * a + (chs[i] - 'a')) % MODULE;
        }
        set.add(h);

        for (int i = len; i < s.length(); i++) {
            h = (h * a - aL * (chs[i - len] - 'a') % MODULE + MODULE) % MODULE;
            h = (chs[i] - 'a') % MODULE;
            if (!set.add(h))
                return i - len + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem1044 p = new Problem1044();

        System.out.println(p.longestDupSubstring("banana"));
    }
}
