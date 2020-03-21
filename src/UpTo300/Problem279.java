package UpTo300;

import java.util.ArrayList;
import java.util.List;

public class Problem279 {
    static List<Integer> dp = new ArrayList<>();

    public static void main(String[] args) {
        Problem279 p = new Problem279();

        System.out.println(p.numSquares(12));
        System.out.println(p.numSquares(13));
    }

    public int numSquares(int n) {
        if (dp.size() == 0) dp.add(0);
        List<Integer> squares = new ArrayList<>();
        int i = 0;
        while (i * i <= n) {
            squares.add(i * i++);
        }
        squares.add(i * i);
        while (dp.size() <= n) {
            int m = dp.size();
            int tmp = Integer.MAX_VALUE;
            for (int j = 1; squares.get(j) <= m; j++) {
                tmp = Math.min(tmp, dp.get(m - squares.get(j)) + 1);
            }
            dp.add(tmp);
        }
        return dp.get(n);
    }
}
