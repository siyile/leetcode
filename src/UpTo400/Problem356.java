package UpTo400;

import java.util.*;

public class Problem356 {
    public boolean isReflected(int[][] points) {
        if (points.length == 0) {
            return true;
        }
        int x = 0, len = 0;
        Map<Integer, TreeSet<Integer>> map1 = new HashMap<>();
        for (int[] point : points) {
            if (!map1.containsKey(point[0])) {
                map1.put(point[0], new TreeSet<>());
            }
            if (map1.get(point[0]).add(point[1])) {
                x += point[0];
                len++;
            }
        }


        if (x * 2 % len != 0) return false;
        double x0 = x * 1.0 / len;

        for (int x1 : map1.keySet()) {
            int x2 = (int) (x0 * 2) - x1;
            if (map1.get(x2) == null) {
                return false;
            }
            if (map1.get(x1).size() != map1.get(x2).size()) {
                return false;
            }
            Iterator<Integer> it1 = map1.get(x1).iterator();
            Iterator<Integer> it2 = map1.get(x2).iterator();
            while (it1.hasNext()) {
                if (it1.next() != it2.next()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem356 p = new Problem356();

        System.out.println(p.isReflected(new int[][]{{-16, 1}, {16, 1}, {16, 1}}));
    }
}
