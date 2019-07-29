package UpTo100;

import utils.TreeNode;

import java.util.Stack;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            TreeNode node = s.pop();
            if (pre != null && pre.val >= node.val) return false;
            pre = node;
            root = node.right;
        }
        return true;
    }
}
