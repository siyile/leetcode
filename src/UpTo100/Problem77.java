package UpTo100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Problem77 {
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combineBT(ans, new ArrayList<>(), n, k, 1);
        return ans;
    }

    private void combineBT(List<List<Integer>> ans, List<Integer> temp, int n, int k, int start) {
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
        }
        for (int i = start; i < n + 1; i++) {
            temp.add(i);
            combineBT(ans, temp, n, k - 1, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (k == 0 || k == n) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; ++i) {
                row.add(i);
            }
            return new LinkedList<>(Arrays.asList(row));
        }
        List<List<Integer>> result = this.combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(this.combine(n - 1, k));
        return result;
    }

    public static void main(String[] args) {
        Problem77 p = new Problem77();

        System.out.println(p.combine(4, 4));
    }
}
