package UpTo100;

public class Problem72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] memo = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            memo[i][0] = i;
        }
        for (int i = 0; i < len2 + 1; i++) {
            memo[0][i] = i;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                } else {
                    int a = memo[i - 1][j - 1];
                    int b = memo[i - 1][j];
                    int c = memo[i][j - 1];
                    memo[i][j] = (a < b ? (a < c ? a : c) : (b < c ? b : c)) + 1;
                }
            }
        }
        return memo[len1][len2];
    }

    public static void main(String[] args) {
        Problem72 p = new Problem72();

        System.out.println(p.minDistance("horse", "ros"));
    }
}
