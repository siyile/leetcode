import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = 0;
        Map<String, Integer> map = new HashMap<>();
        for (List<String> equation :
                equations) {
            for (String x :
                    equation) {
                if (!map.containsKey(x)) {
                    map.put(x, n++);
                }
            }
        }

        List<List<Integer>> graph = new ArrayList<>();
        List<HashMap<Integer, Double>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            edges.add(new HashMap<>());
        }
        for (int i = 0; i < equations.size(); i++) {
            int x = map.get(equations.get(i).get(0));
            int y = map.get(equations.get(i).get(1));
            graph.get(x).add(y);
            graph.get(y).add(x);
            edges.get(x).put(y, values[i]);
            edges.get(y).put(x, 1 / values[i]);
        }
        double[] ans = new double[queries.size()];
        int i = 0;
        for (List<String> query :
                queries) {
            if (!map.containsKey(query.get(0)) || !map.containsKey(query.get(1))) {
                ans[i++] = -1.0;
                continue;
            }
            int x = map.get(query.get(0));
            int y = map.get(query.get(1));
            boolean[] visited = new boolean[queries.size()];
            visited[x] = true;
            List<Integer> path = new ArrayList<>();
            path.add(x);
            double res = 1;
            if (!dfs(graph, x, y, visited, path)) {
                ans[i++] = -1.0;
            } else {
                for (int j = 0; j < path.size() - 1; j++) {
                    res *= edges.get(path.get(j)).get(path.get(j + 1));
                }
                ans[i++] = res;
            }
        }
        return ans;
    }

    private boolean dfs(List<List<Integer>> graph, int node,
                       int target, boolean[] visited, List<Integer> path) {
        if (node == target) return true;
        for (Integer nei :
                graph.get(node)) {
            if (!visited[nei]) {
                visited[nei] = true;
                path.add(nei);
                if (dfs(graph, node, target, visited, path))
                    return true;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    public double[] calcEquation2(List<List<String>> equations, double[] v, List<List<String>> queries) {
        int n = 0;
        Map<String, Integer> map = new HashMap<>();
        for (List<String> equation :
                equations) {
            for (String x :
                    equation) {
                if (!map.containsKey(x)) {
                    map.put(x, n++);
                }
            }
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Map<Pair<Integer, Integer>, Double> values = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            int x = map.get(equations.get(i).get(0));
            int y = map.get(equations.get(i).get(1));
            values.put(new Pair<>(x, y), v[i]);
            parent[y] = x;
        }

        double[] ans = new double[queries.size()];
        int i = 0;
        for (List<String> query :
                queries) {
            if (!map.containsKey(query.get(0)) || !map.containsKey(query.get(1))) {
                ans[i++] = -1.0;
                continue;
            }
            boolean reverse = false;
            int x = map.get(query.get(0));
            int y = map.get(query.get(1));
            if (!check(parent, x, y)) {
                int tmp = x;
                x = y;
                y = tmp;
                if (!check(parent, x, y)) {
                    ans[i++] = -1.0;
                    continue;
                } else {
                    reverse = true;
                }
            }
            double res = 1;
            while (y != x) {
                res *= values.get(new Pair<>(parent[y], y));
                y = parent[y];
            }
            if (reverse) res = 1 / res;
            ans[i++] = res;
        }
        return ans;
    }

    private boolean check(int[] parent, int x, int y) {
        if (y == x)
            return true;
        if (parent[y] == y)
            return false;
        return check(parent, x, parent[y]);
    }
}
