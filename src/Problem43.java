public class Problem43 {
    enum Result {
        TRUE, FALSE
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Result[][] memo = new Result[m + 1][n + 1];
        memo[m][n] = Result.TRUE;
        return match(s, p, 0, 0, memo);
    }

    public boolean match(String s, String p, int i, int j, Result[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans = false;
        int m = s.length();
        int n = p.length();
        if (j == n) {
            ans = m == i;
        }

        if (i < m && j < n) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                ans = match(s, p, i + 1, j + 1, memo);
            } else if(p.charAt(j) == '*') {
                ans = match(s, p, i + 1, j, memo) || match(s, p, i, j + 1, memo);
            }
        } else if (j < n){
            ans = p.charAt(j) == '*' && match(s, p, i, j + 1, memo);
        }

        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public static void main(String[] args) {
        Problem43 p = new Problem43();
        System.out.println(p.isMatch("aa", "**a**"));
        System.out.println(p.isMatch("aa", "****"));
        System.out.println(p.isMatch("cb", "?a"));
        System.out.println(p.isMatch("adceb", "*a*b"));
        System.out.println(p.isMatch("acdcb", "a*c?b"));
//        System.out.println(p.isMatch("aa", "a"));
//        System.out.println(p.isMatch("aa", "a"));
    }
}
