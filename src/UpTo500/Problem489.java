package UpTo500;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Problem489 {
    // up 0, right 1, down 2, left 3
    Robot robot;
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0, new HashSet<>());
    }

    public void backtrack(int x, int y, int d, Set<Pair<Integer, Integer>> visited) {
        visited.add(new Pair<>(x, y));
        robot.clean();


        for (int i = 0; i < 4; i++) {
            int nd = (d + i) % 4;
            int nx = x + dirs[nd][0], ny = y + dirs[nd][1];
            if (!visited.contains(new Pair<>(nx, ny)) && robot.move()) {
                backtrack(nx, ny, nd, visited);
                goBack();
            }

            robot.turnRight();
        }
    }

    interface Robot {
        boolean move();

        void turnLeft();

        void turnRight();

        void clean();
    }

    private class Pair<F, S> {
        public F first;
        public S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return first.hashCode() ^ second.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            Pair<F, S> p = (Pair<F, S>) o;
            return Objects.equals(p.first, first) && Objects.equals(p.second, second);
        }
    }
}
