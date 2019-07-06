import utils.TreeNode;

public class Problem897 {
    public TreeNode increasingBST(TreeNode root) {
        return link(root, null);
    }

    public TreeNode link(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = link(root.left, root);
        root.left = null;
        root.right = link(root.right, tail);
        return res;
    }
}
