package UpTo750;

public class Problem727 {
    public static void main(String[] args) {
        Problem727 p = new Problem727();

        System.out.println(p.minWindow("abcdebdde", "bde"));
    }

    public String minWindow1(String S, String T) {
        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = dp[i][j - 1];
            }
        }

        int start = 0, len = n + 1;
        for (int i = 1; i <= n; i++) {
            if (dp[m][i] != 0)
                if (i - dp[m][i] + 1 < len) {
                    start = dp[m][i] - 1;
                    len = i - dp[m][i] + 1;
                }
        }
        return len == n + 1 ? "" : S.substring(start, start + len);
    }

    public String minWindow(String S, String T) {
        int l = 0, r = 0, n = S.length(), m = T.length();
        int len = n + 1;
        String ans = "";
        while (r < n) {
            int tIndex = 0;
            while (r < n) {
                if (S.charAt(r) == T.charAt(tIndex)) {
                    tIndex++;
                }
                if (tIndex == m)
                    break;
                r++;
            }
            if (r == n)
                break;
            l = r;
            tIndex = m - 1;
            while (tIndex >= 0) {
                while (T.charAt(tIndex) != S.charAt(l))
                    l--;
                tIndex--;
                l--;
            }
            l++;
            if (r - l + 1 < len) {
                len = r - l + 1;
                ans = S.substring(l, r + 1);
            }
            r = l + 1;
        }
        return ans;
    }
}
