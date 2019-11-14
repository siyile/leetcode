package UpTo50;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        int[] cnt = new int[128];
        char[] chs = s.toCharArray();
        int ans = 0;
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (cnt[chs[r]]++ == 1) {
                while (--cnt[chs[l++]] != 1) {}
            }
            ans = Math.max(r - l + 1, ans);
        }
        return ans;
    }
}
