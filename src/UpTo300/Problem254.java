package UpTo300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 2, n);
        return ans;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tmp, int start, int n) {
        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                tmp.add(i);
                tmp.add(n / i);
                res.add(new ArrayList<>(tmp));
                tmp.remove(tmp.size() - 1);
                backtrack(res, tmp, i, n / i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
