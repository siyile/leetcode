package UpTo700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem679 {
    public boolean judgePoint24(int[] nums) {
        List<Double> arr = new ArrayList<>();
        for (int x :
                nums) {
            arr.add((double) x);
        }
        return isGood(arr);
    }

    private boolean isGood(List<Double> arr) {
        int size = arr.size();
        if (size == 1) return Math.abs(arr.get(0) - 24) < 1e-3;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (double x :
                        newel(arr.get(i), arr.get(j))) {
                    List<Double> next = new ArrayList<>();
                    next.add(x);
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) next.add(arr.get(k));
                    }

                    if (isGood(next)) return true;
                }
            }
        }
        return false;
    }

    private List<Double> newel(double x1, double x2) {
        return new ArrayList<>(Arrays.asList(x1 + x2, x1 - x2, x2 - x1, x1 * x2, x1 / x2, x2 / x1));
    }
}
