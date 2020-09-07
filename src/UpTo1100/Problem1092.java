package UpTo1100;

public class Problem1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        char[] s1 = str1.toCharArray(), s2 = str2.toCharArray();
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < str1.length() || j < str2.length()) {
            if (i == m || j == n) {
                sb.append(i == m ? s2[j++] : s1[i++]);
            } else if (s1[i] == s2[j]) {
                sb.append(s1[i++]);
                j++;
            } else {
                sb.append(dp[i + 1][j] > dp[i][j + 1] ? s1[i++] : s2[j++]);
            }
        }
        return sb.toString();
    }
}
