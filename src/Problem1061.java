public class Problem1061 {
    // start union find
    private int[] parent;

    public String smallestEquivalentString(String a, String b, String s) {
        // init
        int n = a.length();
        parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            union(a.charAt(i) - 'a', b.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((char) (find(s.charAt(i) - 'a') + 'a'));
        }

        return sb.toString();
    }

    // path compression
    private int find(int i) {
        if (parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    // union with order
    private void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rootx < rooty) {
                parent[rooty] = rootx;
            } else {
                parent[rootx] = rooty;
            }
        }
    }
}
