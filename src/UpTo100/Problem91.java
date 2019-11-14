package UpTo100;

public class Problem91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if (one > 0 && one < 10) dp[i] += dp[i - 1];
            if (two > 9 && two < 27) dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Problem91 p = new Problem91();
        System.out.println(p.numDecodings("1"));
    }
}
