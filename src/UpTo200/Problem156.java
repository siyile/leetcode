package UpTo200;

import utils.BinaryTree;
import utils.TreeNode;

public class Problem156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        TreeNode ans = root;
        while (ans.left != null) {
            ans = ans.left;
        }
        updown(root);
        return ans;
    }

    public TreeNode updown(TreeNode root) {
        if (root.left == null) return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        newRoot.left = root.right;
        newRoot.right = root;

        root.left = null;
        root.right = null;

        return newRoot.right;
    }

    public static void main(String[] args) {
        Problem156 p = new Problem156();
        BinaryTree t = new BinaryTree(new int[]{1,2,3,4,5});
        System.out.println(p.upsideDownBinaryTree(t.root));
    }
}
