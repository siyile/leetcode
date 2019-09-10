import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1162 {
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length, dis = 0;
        Deque<int[]> q = new ArrayDeque<>();
        boolean waterEmpty = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    q.offer(new int[]{i, j});
                else
                    waterEmpty = false;
            }
        }
        if (q.isEmpty() || waterEmpty) return -1;

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            dis++;
            for (int i = 0; i < size; i++) {
                int x = q.peek()[0], y = q.poll()[1];
                for (int[] dir :
                        dirs) {
                    int X = x + dir[0], Y = y + dir[1];
                    if (X < 0 || Y < 0 || X >= m || Y >= n || grid[X][Y] == 1) continue;
                    grid[X][Y] = 1;
                    q.offer(new int[]{X, Y});
                }
            }
        }
        return dis;
    }
}
