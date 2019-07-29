package UpTo150;

import java.util.ArrayList;
import java.util.List;

public class Problem119 {
    public static void main(String[] args) {
        Problem119 p = new Problem119();

        System.out.println(p.getRow(4));
    }

    List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(0, 1);
            for (int j = 1; j < i; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }
}
