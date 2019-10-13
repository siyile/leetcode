import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1001 {
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap();
        Map<Integer, Integer> col = new HashMap();
        Map<Integer, Integer> d1 = new HashMap();
        Map<Integer, Integer> d2 = new HashMap();
        Set<Pair<Integer, Integer>> status = new HashSet<>();

        for (int[] lamp :
                lamps) {
            int x = lamp[0], y = lamp[1];
            row.put(x, row.getOrDefault(x, 0) + 1);
            col.put(y, col.getOrDefault(y, 0) + 1);
            d1.put(y - x, d1.getOrDefault(y - x, 0) + 1);
            d2.put(x + y, d2.getOrDefault(x + y, 0) + 1);
            status.add(new Pair<>(x, y));
        }

        int[] ans = new int[queries.length];

        int k = 0;
        for (int[] query :
                queries) {
            int x = query[0], y = query[1];
            if (row.getOrDefault(x, 0) > 0 || col.getOrDefault(y, 0) > 0 ||
                    d1.getOrDefault(y - x, 0) > 0 || d2.getOrDefault(x + y, 0) > 0)
                ans[k++] = 1;
            else ans[k++] = 0;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int xp = x + i, yp = y + j;
                    if (xp >= 0 && yp >= 0 && xp < N && yp < N
                            && status.remove(new Pair<>(xp, yp))) {
                        row.put(xp, row.get(xp) - 1);
                        col.put(yp, col.get(yp) - 1);
                        d1.put(yp - xp, d1.get(yp - xp) - 1);
                        d2.put(xp + yp, d2.get(xp + yp) - 1);
                    }
                }
            }
        }

        return ans;
    }
}
