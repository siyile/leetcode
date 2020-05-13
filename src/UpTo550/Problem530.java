package UpTo550;

import utils.TreeNode;

public class Problem530 {
    int diff = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return diff;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != Integer.MAX_VALUE) {
            diff = Math.min(root.val - prev, diff);
        }
        prev = root.val;
        inorder(root.right);
    }
}
