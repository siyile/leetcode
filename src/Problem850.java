import java.util.*;

public class Problem850 {
    int mod = 1_000_000_007;
    public int rectangleArea(int[][] rectangles) {
        List<int[]> list = new ArrayList<>();
        for (int[] r :
                rectangles) {
            list.add(new int[]{r[0], r[1], 1});
            list.add(new int[]{r[0], r[3], -1});
            list.add(new int[]{r[2], r[1], -1});
            list.add(new int[]{r[2], r[3], 1});
        }

        list.sort(Comparator.comparingInt(o -> o[0]));

        TreeMap<Integer, Integer> map = new TreeMap<>();

        long res = 0;
        int prevX = -1;
        long y = -1;

        for (int i = 0; i < list.size(); i++) {
            int[] p = list.get(i);
            map.put(p[1], map.getOrDefault(p[1],0) + p[2]);
            if (map.get(p[1]) == 0) {
                map.remove(p[1]);
            }
            if (i == list.size() - 1 || list.get(i+1)[0] > p[0]) {
                if (prevX > -1) {
                    res += (y * (p[0] - prevX)) % mod;
                    res %= mod;
                }
                y = calY(map);
                prevX = p[0];
            }
        }

        return (int) res;
    }

    private long calY(TreeMap<Integer, Integer> map) {
        if (map.size() == 0) {
            return 0;
        }
        int result = 0, pre = -1, count = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (pre >= 0 && count > 0) {
                result += e.getKey() - pre;
            }
            count += e.getValue();
            pre = e.getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        Problem850 p = new Problem850();

        System.out.println(p.rectangleArea(new int[][]{{25,20,70,27},{68,80,79,100},{37,41,66,76}}));
    }
}
