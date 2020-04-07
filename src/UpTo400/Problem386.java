package UpTo400;

import java.util.ArrayList;
import java.util.List;

public class Problem386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i <= n) {
                dfs(i, res, n);
            }
        }
        return res;
    }

    private void dfs(int cur, List<Integer> ans, int n) {
        ans.add(cur);
        for (int i = 0; i < 10; i++) {
            if (cur * 10 + i > n) {
                return;
            }
            dfs(cur * 10 + i, ans, n);
        }
    }
}
