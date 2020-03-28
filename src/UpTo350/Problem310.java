package UpTo350;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem310 {
    public static void main(String[] args) {
        Problem310 p = new Problem310();

        System.out.println(p.findMinHeightTrees(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> grpah = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grpah.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] edge :
                edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            grpah.get(edge[0]).add(edge[1]);
            grpah.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> q = new ArrayDeque<>();
        int N = n;
        for (int i = 0; i < N; i++) {
            if (degree[i] == 1) {
                q.add(i);
                n--;
            }
        }

        while (!q.isEmpty() && n != 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int nei :
                        grpah.get(node)) {
                    degree[nei]--;
                    if (degree[nei] == 1) {
                        q.add(nei);
                        n--;
                    }
                }
            }
        }

        return new ArrayList<>(q);
    }
}
