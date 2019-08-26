import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Problem968 {
    Set<TreeNode> covered = new HashSet<>();
    int ans = 0;
    int res = 0;

    public int minCameraCover3(TreeNode root) {
        covered.add(null);
        dfs2(null, root);
        return ans;
    }

    private void dfs2(TreeNode parent, TreeNode node) {
        if (node != null) {
            dfs2(node, node.left);
            dfs2(node, node.right);
            if (parent == null && !covered.contains(node) ||
                    !covered.contains(node.left) ||
                    !covered.contains(node.right)) {
                ans++;
                covered.add(parent);
                covered.add(node.left);
                covered.add(node.right);
                covered.add(node);
            }
        }
    }

    public int minCameraCover(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 2;
        int left = dfs(node.left), right = dfs(node.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}
