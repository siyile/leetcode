package UpTo100;

public class Problem76 {
    public static void main(String[] args) {
        Problem76 p = new Problem76();

        System.out.println(p.minWindow("a", "b"));
    }

    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        char[] cht = t.toCharArray();
        char[] chs = s.toCharArray();
        for (char ch :
                cht) {
            cnt[ch] += 1;
        }
        int k = t.length();
        int count = 0;
        int start = 0, len = s.length() + 1;
        for (int r = 0, l = 0; r < s.length(); r++) {
            if (cnt[chs[r]]-- > 0) {
                count++;
            }
            while (l < r && cnt[chs[l]] < 0) {
                if (++cnt[chs[l++]] > 0)
                    count--;
            }
            if (count == k && r - l + 1 < len) {
                start = l;
                len = r - l + 1;
            }
        }
        return len == s.length() + 1 ? "" : s.substring(start, start + len);
    }
}
