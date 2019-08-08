import java.util.HashMap;
import java.util.Map;

public class Problem1124 {
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, ans = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (map.containsKey(sum - 1))
                ans = Math.max(i - map.get(sum - 1), ans);
            map.putIfAbsent(sum, i);
        }
        return ans;
    }
}
