import java.util.*;

public class Problem787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashMap<>());
        }
        for (int[] flight :
                flights) {
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        Queue<Node> q = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.price - o2.price;
            }
        });

        q.add(new Node(-1, 0, src));
        Set<Integer> settled = new HashSet<>();
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.city == dst)
                return node.price;
            settled.add(node.city);
            if (node.stop < K)
                for (Map.Entry<Integer, Integer> entry :
                        graph.get(node.city).entrySet()) {
                    if (!settled.contains(entry.getKey()))
                        q.add(new Node(node.stop + 1, entry.getValue() + node.price, entry.getKey()));
                }
        }
        return -1;
    }

    class Node {
        int stop;
        int price;
        int city;

        public Node(int stop, int price, int node) {
            this.stop = stop;
            this.price = price;
            this.city = node;
        }
    }
}
