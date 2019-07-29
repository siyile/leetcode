import java.util.LinkedList;
import java.util.Queue;

public class Problem994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Integer> q = new LinkedList<>();
        boolean[][] seen = new boolean[m][n];
        int cnt = 0;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(i * n + j);
                    seen[i][j] = true;
                    cnt++;
                } else if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                int pos = q.poll();
                cnt--;
                int x = pos / n;
                int y = pos % n;

                int[] dr = new int[]{1, -1, 0, 0};
                int[] dc = new int[]{0, 0, 1, -1};

                for (int j = 0; j < 4; j++) {
                    int nextX = dr[j] + x;
                    int nextY = dc[j] + y;
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n
                            || seen[nextX][nextY] || grid[nextX][nextY] == 0)
                        continue;
                    q.add(nextX * n + nextY);
                    seen[nextX][nextY] = true;
                }
            }
        }

        if (cnt == 0) return time;
        return -1;
    }
}
