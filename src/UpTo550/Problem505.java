package UpTo550;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem505 {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length, n = maze[0].length;
        int[][] memo = new int[m][n];
        for (int[] me :
                memo) {
            Arrays.fill(me, Integer.MAX_VALUE);
        }
        memo[start[0]][start[1]] = 0;
        dijkstra(memo, maze, start[0], start[1]);
        return memo[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : memo[dest[0]][dest[1]];
    }

//    private void dfs(int[][] memo, int[][] maze, int p, int q) {
//        int m = maze.length, n = maze[0].length;
//        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//        for (int[] dir :
//                dirs) {
//            int x = p + dir[0];
//            int y = q + dir[1];
//            int count = 0;
//            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
//                x += dir[0];
//                y += dir[1];
//                count++;
//            }
//            x -= dir[0];
//            y -= dir[1];
//            if (memo[p][q] + count < memo[x][y]) {
//                memo[x][y] = memo[p][q] + count;
//                dfs(memo, maze, x, y);
//            }
//        }
//    }

    private void dijkstra(int[][] memo, int[][] maze, int p, int q) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        queue.add(new int[]{p, q, 0});
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            if (memo[s[0]][s[1]] < s[2])
                continue;
            int m = maze.length, n = maze[0].length;
            int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int[] dir :
                    dirs) {
                int x = p + dir[0];
                int y = q + dir[1];
                int count = 0;
                while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                if (memo[p][q] + count < memo[x][y]) {
                    memo[x][y] = memo[p][q] + count;
                    queue.add(new int[]{x, y, memo[x][y]});
                }
            }
        }
    }
}
