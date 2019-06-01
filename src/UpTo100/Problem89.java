package UpTo100;

import java.util.ArrayList;
import java.util.List;

public class Problem89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            int size = ans.size();
            for (int j = size - 1; j >= 0; j--) {
                ans.add(ans.get(j) | 1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem89 p = new Problem89();
        System.out.println(p.grayCode(2));
        System.out.println(4 >> 1);
    }
}
