package UpTo50;

public class Problem44 {
    public static void main(String[] args) {
        Problem44 p = new Problem44();
        System.out.println(p.isMatch("acdab", "a*c?b"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Result[][] memo = new Result[m + 1][n + 1];
        return match(s, p, 0, 0, memo);
    }

    public boolean match(String s, String p, int i, int j, Result[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        int m = s.length();
        int n = p.length();
        if (j == n && m == i) {
            ans = true;
        } else {
            boolean firstMatch = j < n && i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?' || p.charAt(j) == '*');
            if (j < n && p.charAt(j) == '*') {
                ans = match(s, p, i, j + 1, memo) || (firstMatch && match(s, p, i + 1, j, memo));

            } else {
                ans = (firstMatch && match(s, p, i + 1, j + 1, memo));
            }
        }

        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    enum Result {
        TRUE, FALSE
    }
}
