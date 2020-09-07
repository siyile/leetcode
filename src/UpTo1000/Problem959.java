package UpTo1000;

public class Problem959 {
    int[] rank;

    public int regionsBySlashes(String[] grids) {
        int n = grids.length;
        int[] parent = new int[n * n * 4];
        rank = new int[parent.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            char[] ch = grids[i].toCharArray();
            for (int j = 0; j < n; j++) {
                int x = (i * n + j) * 4;
                if (i != 0) {
                    union(x, 4 * ((i - 1) * n + j) + 2, parent);
                }
                if (j != 0) {
                    union(x + 3, 4 * (i * n + j - 1) + 1, parent);
                }
                if (ch[j] == ' ') {
                    for (int k = 0; k < 2; k++) {
                        union(x + k, x + k + 1, parent);
                    }
                } else if (ch[j] == '\\') {
                    union(x, x + 1, parent);
                    union(x + 2, x + 3, parent);
                } else {
                    union(x, x + 3, parent);
                    union(x + 1, x + 2, parent);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) cnt++;
        }
        return cnt;
    }

    private void union(int x, int y, int[] parent) {
        int rootx = find(x, parent);
        int rooty = find(y, parent);

        if (rootx != rooty) {
            if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
                rank[rooty]++;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x)
            parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
