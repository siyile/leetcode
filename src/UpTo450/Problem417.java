package UpTo450;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem417 {
    int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        this.matrix = matrix;
        boolean[][] colorPac = new boolean[m][n];
        boolean[][] colorAtl = new boolean[m][n];

        Queue<Integer> q = new LinkedList<>();

        // Pac
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == 0) {
                    q.add(i * n + j);
                    colorPac[i][j] = true;
                }
            }
        }

        bfs(colorPac, q);

        q.clear();

        // Atl
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1 || j == n - 1) {
                    q.add(i * n + j);
                    colorAtl[i][j] = true;
                }
            }
        }

        bfs(colorAtl, q);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (colorAtl[i][j] && colorPac[i][j]) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }

    private void bfs(boolean[][] color, Queue<Integer> q) {
        int m = matrix.length, n = matrix[0].length;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int pos = q.poll();
                int x = pos / n;
                int y = pos % n;
                int[] dr = new int[]{1, -1, 0, 0};
                int[] dc = new int[]{0, 0, 1, -1};
                for (int j = 0; j < 4; j++) {
                    int a = dc[j] + x;
                    int b = dr[j] + y;
                    if (a < 0 || a >= m || b < 0 || b >= n || color[a][b] || matrix[x][y] > matrix[a][b])
                        continue;
                    color[a][b] = true;
                    q.add(a * n + b);
                }
            }
        }
    }
}
