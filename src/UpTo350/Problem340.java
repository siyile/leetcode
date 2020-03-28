package UpTo350;

public class Problem340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int count = 0, l = 0, ans = 0;
        char[] chs = s.toCharArray();
        int[] cnt = new int[128];
        for (int r = 0; r < s.length(); r++) {
            if (cnt[chs[r]]++ == 0) count++;
            while (count > k) if (--cnt[chs[l++]] == 0) count--;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
