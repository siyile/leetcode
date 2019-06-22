package UpTo150;

import utils.BinaryTree;
import utils.TreeNode;

public class Problem110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return depth(root) != -1;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        if (leftDepth == -1) return -1;
        int rightDepth = depth(node.right);
        if (rightDepth == -1) return -1;
        if (Math.abs(rightDepth - leftDepth) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }

    public static void main(String[] args) {
        Problem110 p = new Problem110();
        int[] a = {1,2,2,3,3,0,0,4,4};
        BinaryTree t = new BinaryTree(a);
        System.out.println(p.isBalanced(t.root));
    }
}
