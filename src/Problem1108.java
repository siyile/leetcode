import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1108 {
    public TreeNode bstFromPreorder(int[] preorder) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        deque.push(root);
        int cnt = 0;
        for (Integer val :
                preorder) {
            if (cnt++ == 0) continue;
            TreeNode node = deque.peek();
            TreeNode child = new TreeNode(val);
            while (!deque.isEmpty() && val > deque.peek().val)
                node = deque.poll();
            if (node.val < val) node.right = child;
            else node.left = child;
            deque.push(child);
        }
        return root;
    }
}
