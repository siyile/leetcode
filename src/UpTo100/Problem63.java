package UpTo100;

public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        if (obstacleGrid[0][0] != 1) memo[0][0] = 1;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                memo[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                memo[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    memo[i][j] += memo[i - 1][j] + memo[i][j - 1];
                }
            }
        }
        return memo[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Problem63 p = new Problem63();
        int[][] a = {{0}};
        System.out.println(p.uniquePathsWithObstacles(a));
    }
}
