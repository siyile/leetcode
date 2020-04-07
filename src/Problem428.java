import java.util.*;

public class Problem428 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            List<String> list = new ArrayList<>();
            helper(root, list);
            return String.join("#", list);
        }

        private void helper(Node root, List<String> list) {
            if (root == null) return;
            list.add(String.valueOf(root.val));
            list.add(String.valueOf(root.children.size()));
            for (Node child :
                    root.children) {
                helper(child, list);
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            String[] strings = data.split("#");
            if (strings.length == 0) return null;
            Deque<Integer> q = new ArrayDeque<>();
            for (String str :
                    strings) {
                q.add(Integer.parseInt(str));
            }
            return deHelper(q);
        }

        private Node deHelper(Deque<Integer> q) {
            int val = q.poll();
            int size = q.poll();
            Node node = new Node();
            node.val = val;
            node.children = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                node.children.add(deHelper(q));
            }
            return node;
        }
    }
}
