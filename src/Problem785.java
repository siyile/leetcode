import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem785 {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int i = 0; i < graph.length; i++) {
            if (color[i] != -1) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int j = 0; j < size; j++) {
                        Integer node = q.poll();

                        for (int x :
                                graph[node]) {
                            if (color[x] == -1) {
                                q.add(x);
                                color[x] = color[node] ^ 1;
                            } else if (color[x] == color[node]) {
                                return false;
                            }
                        }
                    }
                }

            }
        }
        return true;
    }
}
