import java.util.ArrayDeque;
import java.util.Deque;

public class Problem542 {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    q.add(i * n + j);
            }
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                int x = q.peek() / n, y = q.poll() % n;
                for (int[] dir :
                        dirs) {
                    int xp = x + dir[0], yp = y + dir[1];
                    if (xp >= 0 && yp >= 0 && xp < m && yp < n &&  matrix[xp][yp] == 1) {
                        matrix[xp][yp] = cnt + 1;
                        q.add(xp * n + yp);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0)
                    matrix[i][j]--;
            }
        }
        return matrix;
    }
}
