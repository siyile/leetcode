package UpTo100;

import utils.BinaryTree;
import utils.TreeNode;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean check(TreeNode node, int minVal, int maxVal) {
        if (node == null) return true;
        boolean ans = true;
        if (node.left != null) ans = node.left.val < node.val && node.left.val > minVal;
        if (node.right != null) ans &= node.right.val > node.val && node.right.val < maxVal;
        return ans && check(node.left, minVal, node.val) && check(node.right, node.val, maxVal);
    }

    public static void main(String[] args) {
        Problem98 p = new Problem98();
        int[] a = {2,1,3};
        BinaryTree t = new BinaryTree(a);
        BinaryTree.printNode(t.root);
        System.out.println(p.isValidBST(t.root));
    }
}
