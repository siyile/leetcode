public class Problem186 {
    public void reverseWords(char[] s) {
        int l = 0, r = 0;
        while (r < s.length) {
            if (s[r] == ' ') {
                reverse(s, l, r - 1);
                l = r + 1;
            }
            r++;
        }
        reverse(s, l, r - 1);
        reverse(s, 0, s.length - 1);
    }

    public void reverse(char[] s, int l, int r) {
        for (int i = l; i < (r + l + 1) / 2; i++) {
            char tmp = s[i];
            s[i] = s[r - (i - l)];
            s[r - (i - l)] = tmp;
        }
    }
}
