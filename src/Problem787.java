import java.util.*;

public class Problem787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashMap<>());
        }
        for (int[] flight : flights) {
            for (int j = 0; j < 3; j++) {
                Map<Integer, Integer> edges = graph.get(flight[0]);
                edges.put(flight[1], flight[2]);
            }
        }

        Queue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.price - o2.price;
            }
        });

        Set<Integer> settled = new HashSet<>();

        q.add(new Node(0, src, K + 1));
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.city == dst) return node.price;
            settled.add(node.city);
            if (node.stop > 0) {
                for (Map.Entry<Integer, Integer> entry :
                        graph.get(node.city).entrySet()) {
                    if (!settled.contains(entry.getKey())) {
                        q.add(new Node(node.price + entry.getValue(), entry.getKey(), node.stop - 1));
                    }
                }
            }
        }

        return -1;
    }

    class Node {
        int price;
        int city;
        int stop;

        public Node(int price, int city, int stop) {
            this.price = price;
            this.city = city;
            this.stop = stop;
        }
    }
}
