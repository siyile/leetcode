import utils.TreeNode;

public class Problem543 {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return max;
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left) + 1;
        int rightDepth = depth(node.right) + 1;
        max = Math.max(leftDepth + rightDepth, max);
        return Math.max(leftDepth, rightDepth);
    }
}
