enum Result {TRUE, FALSE}

public class Problem10 {
    private Result[][] memo;
    private boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    private boolean dp(int i, int j, String text, String pattern){
        if (memo[i][j] != null){
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        }
        else {
            boolean firstMatch = (i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.'));
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*'){
                ans = dp(i, j + 2, text, pattern) || (firstMatch && dp(i + 1, j, text, pattern));
            }
            else {
                ans = firstMatch && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public static void main(String [] args){
        Problem10 p = new Problem10();
        System.out.println(p.isMatch("aab", "c*a*b"));
    }
}
