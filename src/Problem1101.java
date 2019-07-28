import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem1101 {
    private int cnt;
    // union find start
    private int[] parent;
    private int[] rank;

    public int earliestAcq(int[][] logs, int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        cnt = n;

        List<List<Integer>> records = new ArrayList<>();
        for (int[] log :
                logs) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(log[0]);
            tmp.add(log[1]);
            tmp.add(log[2]);
            records.add(tmp);
        }

        records.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });

        for (List<Integer> record :
                records) {
            union(record.get(1), record.get(2));
            if (cnt == 1)
                return record.get(0);
        }
        return -1;
    }

    private int find(int i) { // path compression
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    private void union(int x, int y) { // union with rank
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            cnt--;
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx] += 1;
            }
        }
    }
}
