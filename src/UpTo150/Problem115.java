package UpTo150;

import java.util.Arrays;

public class Problem115 {
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length() + 1][t.length() + 1];
        Arrays.fill(memo[s.length()], 0);
        for (int i = 0; i < s.length() + 1; i++) {
            memo[0][i] = 1;
        }
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                memo[i][j] = t.charAt(i) == s.charAt(j) ? memo[i][j - 1] : memo[i][j - 1] + memo[i - 1][j - 1];
            }
        }
        return memo[s.length() + 1][t.length() + 1];
    }

    private int dp(String s, int i, String t, int j, int[][] memo) {
        if (memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i) != t.charAt(j)) {
            memo[i][j] = dp(s, i + 1, t, j, memo);
            return memo[i][j];
        }
        memo[i][j] = dp(s, i + 1, t, j + 1, memo) + dp(s, i + 1, t, j, memo);
        return memo[i][j];
    }

}
