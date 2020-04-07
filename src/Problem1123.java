import utils.TreeNode;

public class Problem1123 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int depth = findDepth(root, 0);
        return lca(root, 0, depth);
    }

    private int findDepth(TreeNode node, int d) {
        if (node == null) return d - 1;
        return Math.max(findDepth(node.left, d + 1), findDepth(node.right, d + 1));
    }

    private TreeNode lca(TreeNode node, int d, int t) {
        if (node == null) return null;
        if (node.left == null && node.right == null && d == t) return node;
        TreeNode left = lca(node.left, d + 1, t);
        TreeNode right = lca(node.right, d + 1, t);
        if (left != null && right != null) return node;
        if (left != null) return left;
        return right;
    }
}
