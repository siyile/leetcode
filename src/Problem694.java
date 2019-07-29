import java.util.HashSet;
import java.util.Set;

public class Problem694 {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        Set<String> s = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, visited, grid, sb, i, j);
                    s.add(sb.toString());
                }
            }
        }
        return s.size();
    }

    private void dfs(int x, int y, boolean[][] visited, int[][] grid, StringBuilder sb, int pi, int pj) {
        int m = visited.length;
        int n = visited[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] == 0) return;
        visited[x][y] = true;
        sb.append(pi - x);
        sb.append(pj - y);
        dfs(x + 1, y, visited, grid, sb, pi, pj);
        dfs(x, y + 1, visited, grid, sb, pi, pj);
        dfs(x - 1, y, visited, grid, sb, pi, pj);
        dfs(x, y - 1, visited, grid, sb, pi, pj);
    }
}
