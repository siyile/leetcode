package Upto250;

import java.util.ArrayList;
import java.util.List;

public class Problem216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        return combination(k, n, 1);
    }

    private List<List<Integer>> combination(int k, int n, int start) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k == 1) {
            if (n >= start && n <= 9) {
                List<Integer> list = new ArrayList<>();
                list.add(n);
                ans.add(list);
            }
            return ans;
        }
        for (int i = start; n - i >= 0 && i <= 9; i++) {
            for (List<Integer> list : combination(k - 1, n - i, i + 1)) {
                list.add(i);
                ans.add(list);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem216 p = new Problem216();

        System.out.println(p.combinationSum3(3, 9));
    }
}
