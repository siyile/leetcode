package UpTo150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem120 {
    public static void main(String[] args) {
        Problem120 p = new Problem120();
        List<List<Integer>> total = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(2);
        total.add(temp);
        temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        total.add(temp);
        temp = new ArrayList<>();
        temp.add(6);
        temp.add(5);
        temp.add(7);
        total.add(temp);
        temp = new ArrayList<>();
        temp.add(4);
        temp.add(1);
        temp.add(8);
        temp.add(3);
        total.add(temp);
        System.out.println(p.minimumTotal(total));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = triangle.get(i);
            row.set(0, row.get(0) + prevRow.get(0));
            for (int j = 1; j < i; j++) {
                row.set(j, row.get(j) + Math.min(prevRow.get(j), prevRow.get(j - 1)));
            }
            row.set(i, row.get(i) + prevRow.get(i - 1));
        }
        List<Integer> row = triangle.get(triangle.size() - 1);
        return Collections.min(row);
    }
}
