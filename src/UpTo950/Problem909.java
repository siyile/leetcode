package UpTo950;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem909 {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n + 1];

//         construct 1d Array
        int x = n - 1, y = 0, cnt = 0, adds = 1;
        while (++cnt <= n * n) {
            arr[cnt] = board[x][y];
            if (y + adds >= n || y + adds < 0) {
                x--;
                adds *= -1;
            } else {
                y += adds;
            }
        }

        boolean[] visited = new boolean[n * n];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                if (node == n * n) return step - 1;
                for (int j = 1; j <= 6; j++) {
                    int nei = j + node;
                    if (nei > n * n) break;
                    int dest = arr[nei] > -1 ? arr[nei] : nei;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        q.add(dest);
                    }
                }
            }
        }

        return -1;
    }
}
