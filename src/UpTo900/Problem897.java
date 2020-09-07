package UpTo900;

import utils.TreeNode;

public class Problem897 {
    TreeNode cur;

    public TreeNode increasingBST1(TreeNode root) {
        return increasingBST1(root, null);
    }

    public TreeNode increasingBST1(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST1(root.left, root);
        root.left = null;
        root.right = increasingBST1(root.right, tail);
        return res;
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
}
