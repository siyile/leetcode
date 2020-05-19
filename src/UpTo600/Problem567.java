package UpTo600;

public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[128];
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i)]++;
            count++;
        }

        int l = 0, r = 0;
        char[] chs = s2.toCharArray();
        while (r < chs.length) {
            if (cnt[chs[r++]]-- > 0) {
                count--;
            } else {
                while (l < r && ++cnt[chs[l++]] != 0) {
                    count++;
                }
            }

            if (count == 0) return true;
        }
        return false;
    }
}
