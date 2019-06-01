package UpTo100;

public class Problem64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] memo = new int[n];
        memo[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            memo[i] = memo[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            memo[0] = memo[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                memo[j] = grid[i][j] + Math.min(memo[j], memo[j - 1]);
            }
        }
        return memo[n - 1];
    }
    public static void main(String[] args) {
        Problem64 p = new Problem64();
        int[][] a = {{1,2},{5,6},{1,1}};
        System.out.println(p.minPathSum(a));
    }
}
