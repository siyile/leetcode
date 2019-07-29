package UpTo150;

import java.util.ArrayList;
import java.util.List;

public class Problem118 {
    public static void main(String[] args) {
        Problem118 p = new Problem118();
        System.out.println(p.generate(1));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        if (numRows == 1) return ans;
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        ans.add(temp);
        if (numRows == 2) return ans;
        for (int i = 2; i < numRows; i++) {
            temp = new ArrayList<>();
            temp.add(1);
            List<Integer> last = ans.get(i - 1);
            for (int j = 0; j < i - 1; j++) {
                temp.add(last.get(j) + last.get(j + 1));
            }
            temp.add(1);
            ans.add(temp);
        }
        return ans;
    }
}
