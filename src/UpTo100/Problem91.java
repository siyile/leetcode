package UpTo100;

public class Problem91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] memo = new int[len + 2];
        memo[len] = 1;
        memo[len + 1] = 1;
        for (int i = len - 1; i >= 0 ; i--) {
            final int i1 = memo[i + 1] + memo[i + 2];
            if ((s.charAt(i) == '1' && i < len - 1) || (s.charAt(i) == '2' && (i + 1 < len && s.charAt(i + 1) - '0' < 7))) {
                memo[i] = i1;
            } else if (s.charAt(i) != '0'){
                memo[i] = memo[i + 1];
            }
        }
        return memo[0];
    }

    public static void main(String[] args) {
        Problem91 p = new Problem91();
        System.out.println(p.numDecodings("1"));
    }
}
