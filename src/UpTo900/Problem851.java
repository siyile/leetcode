package UpTo900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem851 {
    int[] quiet;
    int[] ans;
    List<List<Integer>> graph;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        graph = new ArrayList<>();
        this.quiet = quiet;
        ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] rich :
                richer) {
            graph.get(rich[1]).add(rich[0]);
        }


        for (int i = 0; i < n; i++) {
            dfs(i);
        }

        return ans;
    }

    private int dfs(int node) {
        if (ans[node] == -1) {
            ans[node] = node;
            for (Integer x :
                    graph.get(node)) {
                int cand = dfs(x);
                if (quiet[cand] < quiet[ans[node]])
                    ans[node] = cand;
            }
        }
        return ans[node];
    }
}
