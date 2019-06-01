package UpTo100;

import java.util.ArrayList;
import java.util.List;

public class Problem60 {
    public String getPermutation(int n, int k) {
        List<Integer> a = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            a.add(i);
        }
        getFirst(n, k - 1, a, ans);
        StringBuilder sb = new StringBuilder();
        for (Integer x :
                ans) {
            sb.append(x);
        }
        return sb.toString();
    }

    private void getFirst(int n, int k, List<Integer> a, List<Integer> ans) {
        if (n == 1) {
            ans.add(a.get(0));
            return;
        }
        int mult = 1;
        for (int i = 1; i < n; i++) {
            mult *= i;
        }
        int index = k / mult;
        ans.add(a.get(index));
        a.remove(index);
        if (n > 0) getFirst(n - 1, k % mult, a, ans);
    }

    public static void main(String[] args) {
        Problem60 p = new Problem60();
        System.out.println(p.getPermutation(4, 9));
    }
}
