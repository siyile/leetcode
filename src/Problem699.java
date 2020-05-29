import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Problem699 {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        int max = 0;
        for (int[] p :
             positions) {
            int start = p[0], end = p[1] + start;
            // get max height
            int from = map.floorKey(start);
            int height = map.subMap(from, end).values().stream().max(Integer::compare).get() + p[1];
            max = Math.max(height, max);
            res.add(max);
            // delete key from start(inclusive) to end(exclusive)
            int lastHeight = map.floorEntry(end).getValue();
            map.put(start, height);
            map.put(end, lastHeight);
            map.subMap(start, false, end, false).clear();
        }
        return res;
    }
}
