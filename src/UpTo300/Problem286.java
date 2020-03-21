package UpTo300;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem286 {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0)
                    q.add(i * n + j);
            }
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int dis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.peek() / n, y = q.poll() % n;
                rooms[x][y] = dis;
                for (int[] dir :
                        dirs) {
                    int X = x + dir[0], Y = y + dir[1];
                    if (X < 0 || Y < 0 || X >= m || Y >= n) continue;
                    if (rooms[X][Y] == Integer.MAX_VALUE) {
                        q.add(X * n + Y);
                        rooms[X][Y] = -1;
                    }
                }
            }
            dis++;
        }
    }
}
