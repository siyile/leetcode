import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Problem1210 {
    int n;
    int[][] grid;
    Queue<Pos> q;
    Set<Integer> seen;

    public int minimumMoves(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        q = new ArrayDeque<>();
        seen = new HashSet<>();
        Pos tmp = new Pos(0, 0, 0);
        q.add(tmp);
        seen.add(0);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pos node = q.poll();
                if (node.x1 == n - 1 && node.y1 == n - 2 && node.dir == 0)
                    return step;

                // right
                tmp = new Pos(node.x1, node.y1 + 1, node.dir);
                if (tmp.check()) add(tmp);
                // bottom
                tmp = new Pos(node.x1 + 1, node.y1, node.dir);
                if (tmp.check()) add(tmp);

                // clockwise
                if (node.dir == 0) {
                    tmp = new Pos(node.x1, node.y1, 1);
                    if (tmp.check() && grid[tmp.x1 + 1][tmp.y1 + 1] == 0)
                        add(tmp);
                    // counter clockwise
                } else if (node.dir == 1) {
                    tmp = new Pos(node.x1, node.y1, 0);
                    if (tmp.check() && grid[tmp.x1 + 1][tmp.y1 + 1] == 0)
                        add(tmp);
                }

            }
            step++;
        }
        return -1;
    }

    public void add(Pos node) {
        // hash seen
        if (seen.add((node.x1 * n + node.y1) * 2 + node.dir)) {
            q.add(node);
        }
    }

    class Pos {
        int x1;
        int y1;
        int x2;
        int y2;
        // 0 toward right, 1 toward bottom
        int dir;


        // init with directions
        public Pos(int x, int y, int dir) {
            this.x1 = x;
            this.y1 = y;
            this.dir = dir;
            if (dir == 0) {
                y2 = y + 1;
                x2 = x;
            } else if (dir == 1) {
                y2 = y;
                x2 = x + 1;
            }
        }

        public boolean check() {
            return (x2 >= 0 && y2 >= 0 && x1 >= 0 && y1 >= 0 && x2 < n && y2 < n && x1 < n && y1 < n && grid[x1][y1] == 0 && grid[x2][y2] == 0);
        }

        // not necessary
        @Override
        public int hashCode() {
            return (x1 * n + y1) * 2 + dir;
        }
    }
}
