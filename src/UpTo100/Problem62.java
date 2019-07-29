package UpTo100;

public class Problem62 {
    public static void main(String[] args) {
        Problem62 p = new Problem62();

        System.out.println(p.uniquePaths(1, 1));
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        memo[0][0] = 1;
        return move(m - 1, n - 1, m, n, memo);
    }

    private int move(int i, int j, int m, int n, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int ans = 0;
        if (i - 1 > -1) ans += move(i - 1, j, m, n, memo);
        if (j - 1 > -1) ans += move(i, j - 1, m, n, memo);
        memo[i][j] = ans;
        return ans;
    }
}
