import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Problem1293 {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];

        for (int[][] a :
                dp) {
            for (int[] b :
                    a) {
                Arrays.fill(b, Integer.MAX_VALUE);
            }
        }

        dp[0][0][k] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, k});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int i = pos[0], j = pos[1];
            if (i == m - 1 && j == n - 1)
                return dp[i][j][pos[2]];
            for (int[] dir :
                    dirs) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if (x >= 0 && y >= 0 && x < m && y < n) {
                    int cur = dp[x][y][pos[2]];
                    int next = pos[2];
                    if (grid[x][y] == 1) {
                        next--;
                    }
                    if (next >= 0 && dp[x][y][next] > cur + 1){
                        dp[x][y][next] = cur + 1;
                        q.offer(new int[]{x, y, next});
                    }
                }
            }
        }

        return -1;
    }
}
