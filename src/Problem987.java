import utils.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Node> store = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        visit(root, store, 0, 0);
        store.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                }
                if (o1.y != o2.y) {
                    return o1.y - o2.y;
                }
                return o1.val - o2.val;
            }
        });
        int cur = store.get(0).x;
        List<Integer> tmp = new ArrayList<>();
        for (Node node :
                store) {
            if (cur != node.x) {
                ans.add(tmp);
                tmp = new ArrayList<>();
            }
            tmp.add(node.val);
        }
        ans.add(tmp);
        return ans;
    }

    public void visit(TreeNode node, List<Node> store, int x, int y) {
        if (node == null) return;
        store.add(new Node(x, y, node.val));
        visit(node.left, store, x - 1, y - 1);
        visit(node.right, store, x + 1, y - 1);
    }

    class Node {
        int x;
        int y;
        int val;

        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
