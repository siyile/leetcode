public class Problem1100 {
    public static void main(String[] args) {
        Problem1100 p = new Problem1100();

        System.out.println(p.numKLenSubstrNoRepeats("nn", 2));
    }

    public int numKLenSubstrNoRepeats(String S, int K) {
        int[] chs = new int[26];
        int cnt = 0;
        int r = 0, l = 0;
        int ans = 0;
        while (r < S.length()) {
            while (cnt < K && r < S.length()) {
                if (++chs[S.charAt(r++) - 'a'] > 1) {
                    while (l < r) {
                        cnt--;
                        if (--chs[S.charAt(l++) - 'a'] == 1)
                            break;
                    }
                }
                cnt++;
            }
            if (cnt == K && l < r) {
                ans++;
                cnt--;
                chs[S.charAt(l++) - 'a']--;
            }
        }
        return ans;
    }
}
