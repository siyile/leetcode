import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem996 {
    Map<Integer, Integer> cnt = new HashMap<>();
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    public int numSquarefulPerms(int[] A) {
        for (int x : A) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            graph.putIfAbsent(x, new HashSet<>());
        }

        for (int x : cnt.keySet()) {
            for (int y : cnt.keySet()) {
                double c = Math.sqrt(x + y);
                if (c == Math.floor(c)) {
                    graph.get(x).add(y);
                    graph.get(y).add(x);
                }
            }
        }
        int ans = 0;
        for (int x :
                cnt.keySet()) {
            ans += dfs(x, A.length - 1);
        }
        return ans;
    }

    private int dfs(int node, int left) {
        cnt.put(node, cnt.get(node) - 1);
        int count = left == 0 ? 0 : 1;
        for (int nei :
                graph.get(node)) {
            if (cnt.get(nei) != 0) {
                count += dfs(nei, left - 1);
            }
        }
        cnt.put(node, cnt.get(node) + 1);
        return count;
    }
}
