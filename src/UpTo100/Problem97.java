package UpTo100;

public class Problem97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[] memo = new boolean[s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 && j == 0) {
                    memo[j] = true;
                } else if (i == 0) {
                    memo[j] = memo[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    memo[j] = memo[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    memo[j] = (memo[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (memo[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return memo[s2.length()];
    }

    public static void main(String[] args) {
        Problem97 p = new Problem97();

        System.out.println(p.isInterleave("a", "b", "a"));
    }
}
