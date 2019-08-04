package UpTo50;

public class Problem44 {
    public boolean isMatch2(String text, String pattern) {
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();

        boolean[][] dp = new boolean[t.length + 1][p.length + 1];
        dp[t.length][p.length] = true;
        for (int i = t.length; i >= 0; i--) {
            for (int j = p.length - 1; j >= 0; j--) {
                if (p[j] == '*') {
                    if (i < t.length)
                        dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                    else
                        dp[i][j] = dp[i][j + 1];
                } else if (p[j] == '?') {
                    if (i < t.length)
                        dp[i][j] = dp[i + 1][j + 1];
                } else {
                    if (i < t.length)
                        dp[i][j] = dp[i + 1][j + 1] && p[j] == t[i];
                }
            }
        }
        return dp[0][0];
    }

    public boolean isMatch(String text, String pattern) {
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();
        int i = 0;
        int j = 0;
        int start = -1;
        int stmp = -1;
        while (i < t.length) {
            if (j < p.length && (p[j] == '?' || t[i] == p[j])) {
                j++;
                i++;
            } else if (j < p.length && p[j] == '*') {
                start = j;
                stmp = i;
                j++;
            } else if (start == -1) {
                return false;
            } else {
                j = start + 1;
                i = stmp + 1;
                stmp = i;
            }
        }

        for (int k = j; k < p.length; k++) {
            if (p[j] != '*') return false;
        }
        return true;
    }
}
