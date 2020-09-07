package UpTo1100;

import javafx.util.Pair;

import java.util.*;

public class Problem1066 {
    public int assignBikes(int[][] workers, int[][] bikes) {
        Queue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        q.add(new Node(0, 0, 0));
        Set<Pair<Integer, Integer>> seen = new HashSet<>();
        while (true) {
            Node node = q.poll();
            int cost = node.cost;
            int mask = node.mask;
            int worker = node.worker;
            if (worker == bikes.length) return cost;
            if (seen.contains(new Pair<>(worker, mask)))
                continue;
            seen.add(new Pair<>(worker, mask));
            for (int i = 0; i < bikes.length; i++) {
                if ((mask & (1 << i)) == 1)
                    continue;
                q.add(new Node(cost + dis(workers[worker], bikes[i]), mask | (1 << i), worker + 1));
            }
        }
    }

    private int dis(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    class Node {
        int cost;
        int mask;
        int worker;

        Node(int cost, int mask, int worker) {
            this.cost = cost;
            this.mask = mask;
            this.worker = worker;
        }
    }
}
