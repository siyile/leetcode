import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem1136 {
    public int minimumSemesters(int N, int[][] relations) {
        int semester = 0;
        int[] degree = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation :
                relations) {
            graph.get(relation[0]).add(relation[1]);
            degree[relation[1]]++;
        }
        degree[0] = 1;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            if (degree[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            semester++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                for (int nei :
                        graph.get(node)) {
                    degree[nei]--;
                    if (degree[nei] == 0) {
                        q.add(nei);
                        N--;
                    }
                }
            }
        }
        return N == 0 ? semester : -1;
    }
}
