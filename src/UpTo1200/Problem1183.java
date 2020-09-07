package UpTo1200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem1183 {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[][] sq = new int[sideLength][sideLength];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sq[i % sideLength][j % sideLength] += 1;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                list.add(sq[i][j]);
            }
        }

        Collections.sort(list, Comparator.comparingInt(o -> o));
        int sum = 0;
        for (int i = 0; i < maxOnes; i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
