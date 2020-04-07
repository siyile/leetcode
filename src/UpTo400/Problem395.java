package UpTo400;

public class Problem395 {
    public int longestSubstring(String s, int k) {
        int len = 0;
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] cnt = new int[26];
            int curUnique = 0, numNoSmallThanK = 0;
            for (int r = 0, l = 0; r < s.length(); r++) {
                if (cnt[s.charAt(r) - 'a']++ == 0) {
                    curUnique++;
                }
                if (cnt[s.charAt(r) - 'a'] == k) {
                    numNoSmallThanK++;
                }
                while (curUnique > targetUnique) {
                    if (--cnt[s.charAt(l) - 'a'] == 0) {
                        curUnique--;
                    }
                    if (cnt[s.charAt(l++) - 'a'] == k - 1) {
                        numNoSmallThanK--;
                    }
                }
                if (numNoSmallThanK == targetUnique && curUnique == targetUnique) {
                    len = Math.max(len, r - l + 1);
                }
            }
        }
        return len;
    }
}
