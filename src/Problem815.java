import java.util.*;

public class Problem815 {
    public int numBusesToDestination(int[][] routes, int s, int t) {
        if (s == t)
            return 0;
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> start = new HashSet<>();
        Set<Integer> end = new HashSet<>();

        Set<Integer> seen = new HashSet<>();

        int n = routes.length;
        for (int[] route :
                routes) {
            Arrays.sort(route);
            graph.add(new ArrayList<>());
        }

        // create graph
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(routes[i], routes[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(routes[i], s) >= 0) {
                seen.add(i);
                start.add(i);
            }
            if (Arrays.binarySearch(routes[i], t) >= 0) {
                end.add(i);
                seen.add(i);
            }
        }

        int cnt = 0;
        while (!start.isEmpty() && !end.isEmpty()) {
            if (start.size() > end.size()) {
                Set<Integer> tmp = start;
                start = end;
                end = tmp;
            }
            Set<Integer> tmp = new HashSet<>();
            for (Integer route :
                    start) {
                for (Integer nei :
                        graph.get(route)) {
                    if (end.contains(route))
                        return cnt + 1;
                    if (!seen.contains(route)) {
                        seen.add(route);
                        tmp.add(route);
                    }
                }
            }
            start = tmp;
            cnt++;
        }
        return -1;
    }

    public boolean intersect(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j])
                return true;
            else if (a[i] < b[j])
                i++;
            else
                j--;
        }
        return false;
    }
}
