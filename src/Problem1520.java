import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1520 {
    private int check(int[] l, int[] r, int i, String s) {
        char[] chs = s.toCharArray();
        int right = r[chs[i] - 'a'];
        for (int j = i; j <= right; j++) {
            if (l[chs[j] - 'a'] < i) {
                return -1;
            }
            right = Math.max(right, r[chs[j] - 'a']);
        }
        return right;
    }

    public List<String> maxNumOfSubstrings(String s) {
        int[] l = new int[26];
        Arrays.fill(l, s.length());
        int[] r = new int[26];
        for (int i = 0; i < s.length(); i++) {
            l[s.charAt(i) - 'a'] = Math.min(i, l[s.charAt(i) - 'a']);
            r[s.charAt(i) - 'a'] = Math.max(i, r[s.charAt(i) - 'a']);
        }
        List<String> res = new ArrayList<>();
        int right = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (i == l[s.charAt(i) - 'a']) {
                int newRight = check(l, r, i, s);
                if (newRight != -1) {
                    if (res.isEmpty() || i > right) {
                        res.add("");
                    }
                    right = newRight;
                    res.set(res.size() - 1, s.substring(i, right + 1));
                }
            }
        }
        return res;
    }
}
