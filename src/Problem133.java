import utils.Node;

import java.util.*;

public class Problem133 {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        Node ref = new Node();
        ref.val = node.val;
        map.put(node, ref);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            List<Node> neighbors = new ArrayList<>();
            Node target = map.get(cur);
            for (Node x :
                    cur.neighbors) {
                Node n;
                if (!map.containsKey(x)) {
                    n = new Node();
                    n.val = x.val;
                    map.put(x, n);
                    q.offer(x);
                } else {
                    n = map.get(x);
                }
                neighbors.add(n);
            }
            target.neighbors = neighbors;
        }
        return ref;
    }
}
