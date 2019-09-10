import java.util.HashSet;
import java.util.Set;

public class Problem694 {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, grid, sb);
                    if (set.add(sb.toString()))
                        count++;
                }
        }
        return count;
    }

    public void dfs(int x, int y, int[][] grid, StringBuilder sb) {
        int m = grid.length, n = grid[0].length;
        grid[x][y] = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < 4; i++) {
            int[] dir = dirs[i];
            int X = x + dir[0], Y = y + dir[1];
            if (X >= 0 && Y >= 0 && X < m && Y < n && grid[X][Y] == 1) {
                sb.append(i);
                dfs(X, Y, grid, sb);
            }
        }
        sb.append('4');
    }
}
