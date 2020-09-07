package UpTo950;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Problem913 {
    final int DRAW = 0, MOUSE_WIN = 1, CAT_WIN = 2, MOUSE_TURN = 1, CAT_TURN = 2;

    public int catMouseGame(int[][] graph) {
        int N = graph.length;

        int[][][] status = new int[50][50][3];
        int[][][] children_num = new int[50][50][3];

        for (int m = 0; m < N; m++) {
            for (int c = 0; c < N; c++) {
                children_num[m][c][MOUSE_TURN] = graph[m].length;
                children_num[m][c][CAT_TURN] = graph[c].length;
                for (int x :
                        graph[c]) {
                    if (x == 0) {
                        children_num[m][c][CAT_TURN]--;
                        break;
                    }
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 1; i < N; i++) {
            for (int t = 1; t <= 2; t++) {
                status[0][i][t] = MOUSE_WIN;
                q.add(new int[]{0, i, t, MOUSE_WIN});
                status[i][i][t] = CAT_WIN;
                q.add(new int[]{i, i, t, CAT_WIN});
            }
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int m = node[0], c = node[1], t = node[2], s = node[3];
            for (int[] parent : getParent(m, c, t, graph)) {
                int m2 = parent[0], c2 = parent[1], t2 = parent[2];
                if (status[m2][c2][t2] == DRAW) {
                    if (t2 == s) {
                        status[m2][c2][t2] = s;
                        q.add(new int[]{m2, c2, t2, s});
                    } else {
                        if (--children_num[m2][c2][t2] == 0) {
                            status[m2][c2][t2] = t2 == MOUSE_TURN ? CAT_WIN : MOUSE_WIN;
                            q.add(new int[]{m2, c2, t2, status[m2][c2][t2]});
                        }
                    }
                }
            }
        }
        return status[1][2][MOUSE_TURN];
    }

    private List<int[]> getParent(int m, int c, int t, int[][] graph) {
        List<int[]> ans = new ArrayList<>();
        if (t == CAT_TURN) {
            for (int m2 :
                    graph[m]) {
                ans.add(new int[]{m2, c, MOUSE_TURN});
            }
        } else {
            for (int c2 :
                    graph[c]) {
                if (c2 > 0) {
                    ans.add(new int[]{m, c2, CAT_TURN});
                }
            }
        }
        return ans;
    }
}
