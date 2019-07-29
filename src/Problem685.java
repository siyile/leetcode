public class Problem685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] can2 = new int[]{-1, -1};
        int[] can1 = new int[]{-1, -1};
        for (int[] edge :
                edges) {
            if (parent[edge[1]] == 0) {
                parent[edge[1]] = edge[0];
            } else {
                can1[0] = parent[edge[1]];
                can1[1] = edge[1];
                can2[0] = edge[0];
                can2[1] = edge[1];
                edge[1] = 0;
                break;
            }
        }
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge :
                edges) {
            int child = edge[1], father = edge[0];
            if (find(parent, father) == child) {
                if (can2[1] == -1) {
                    return edge;
                }
                return can1;
            }
        }
        return can2;
    }

    public int find(int[] parent, int node) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
}
