package UpTo1000;

public class Problem990 {
    private int[] parent;
    private int[] rank;

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (String s :
                equations) {
            if (s.charAt(1) == '=') {
                union(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }

        for (String s :
                equations) {
            if (s.charAt(1) == '!') {
                if (find(s.charAt(0) - 'a') != find(s.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    private int find(int i) {
        if (parent[i] != i)
            parent[i] = find(parent[i]);
        return parent[i];
    }

    private void union(int x, int y) {
        int xroot = find(x);
        int yroot = find(y);

        if (rank[xroot] > rank[yroot]) {
            parent[yroot] = xroot;
            rank[yroot]++;
        } else if (rank[yroot] > rank[xroot]) {
            parent[xroot] = yroot;
            rank[xroot]++;
        } else {
            parent[xroot] = yroot;
            rank[xroot]++;
        }
    }
}
