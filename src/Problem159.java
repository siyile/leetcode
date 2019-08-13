public class Problem159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] memo = new int[128];
        int ans = 0, K = 2;
        char[] chs = s.toCharArray();
        int cnt = 0;
        for (int l = 0, r = 0; r < chs.length; r++) {
            if (memo[chs[r]]++ == 0) cnt++;
            while (cnt > K) {
                if (--memo[chs[l++]] == 0) {
                    cnt--;
                }
            }
            ans = Math.max(r - l + 1, ans);
            StringBuilder sb = new StringBuilder();
        }
        return ans;
    }
}
