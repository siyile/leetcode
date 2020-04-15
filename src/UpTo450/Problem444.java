package UpTo450;

import java.util.*;

public class Problem444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        int[] parent = new int[n];

        Arrays.fill(parent, -1);

        boolean[] seen = new boolean[n];
        for (List<Integer> seq :
                seqs) {
            if (seq.size() == 1) {
                int x = seq.get(0) - 1;
                if (x < 0 || x >= n) return false;
                seen[x] = true;
            }

            for (int i = 0; i < seq.size() - 1; i++) {
                int x = seq.get(i) - 1;
                int y = seq.get(i + 1) - 1;
                if (x >= n || y >= n || x < 0 || y < 0) return false;
                if (x == y) return false;
                if (!seen[x]) seen[x] = true;
                if (!seen[y]) seen[y] = true;
                if (!check(parent, x, y))
                    parent[y] = x;
            }
        }

        for (boolean x:
                seen) {
            if (!x) return false;
        }

        seen = new boolean[n];
        int cnt = 0;
        for (int x :
                parent) {
            if (x == -1) {
                cnt++;
                continue;
            }
            if (seen[x])
                return false;
            seen[x] = true;
        }
        if (cnt != 1) return false;

        boolean[] visited = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> tmp = new ArrayList<>();
                while (i != -1 && !visited[i]) {
                    visited[i] = true;
                    tmp.add(0, i);
                    i = parent[i];
                }
                ans.addAll(tmp);
            }
        }

        if (ans.size() != org.length) return false;
        for (int i = 0; i < n; i++) {
            if (ans.get(i) + 1 != org[i])
                return false;
        }
        return true;
    }

    private boolean check(int[] parent, int x, int y) {
        if (y == x)
            return true;
        if (parent[y] == -1)
            return false;
        return check(parent, x, parent[y]);
    }

    public int largestUniqueNumber(int[] a) {
        Integer[] A = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            A[i] = a[i];
        }
        Arrays.sort(A, Collections.reverseOrder());
        int i = 0;
        while (i < A.length) {
            if (i == A.length - 1)
                return A[i];
            if (A[i] == A[i + 1]) {
                int cur = A[i];
                while (i < A.length && A[i] == cur) {
                    System.out.println(A[i] + " " + cur);
                    i++;
                }
            } else {
                System.out.println(i);
                return A[i];
            }
        }
        return -1;
    }
}
