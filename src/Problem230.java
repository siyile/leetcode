import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem230 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode node = root;
        while (true) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            node = s.poll();
            k--;
            if (k == 0) return node.val;
            node = node.right;
        }
    }
}
