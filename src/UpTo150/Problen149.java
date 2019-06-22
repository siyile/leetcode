package UpTo150;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Problen149 {
    Map<Pair<Integer, Integer>, Integer> lines = new HashMap<>();
    public Pair<Integer, Integer> check(int[][] points, int i, int j, int duplicates) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];
        int count = 0;
        // duplicate
        if (x1 == x2 && y1 == y2) {
            duplicates++;
        } else {
            int gcd = generateGCD(x1 - x2, y1 - y2);
            Pair<Integer, Integer> temp = new Pair<>((x1 - x2) / gcd, (y1 - y2) / gcd);
            count = lines.getOrDefault(temp, 0) + 1;
            lines.put(temp, count);
        }
        return new Pair<>(count, duplicates);
    }

    public int addLines(int[][] points, int i) {
        int duplicates = 1;
        int max = -1;
        int count = -1;
        lines.clear();
        for (int j = i + 1; j < points.length; j++) {
            Pair<Integer, Integer> res = check(points, i, j, duplicates);
            count = Math.max(res.getKey(), count);
            duplicates = res.getValue();
            max = Math.max(duplicates + count, max);
        }
        return max;
    }


    public int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;
        int max_count = -1;
        for (int i = 0; i < points.length; i++) {
            max_count = Math.max(max_count, addLines(points, i));
        }
        return max_count;
    }

    private int generateGCD(int a,int b) {
        if (b == 0) return a;
        else return generateGCD(b,a % b);
    }

    public static void main(String[] args) {
        Problen149 p = new Problen149();
        System.out.println(p.maxPoints(new int[][]{{0,0},{1,1},{0,0}}));
    }
}
