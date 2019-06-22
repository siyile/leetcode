package UpTo150;

import utils.BinaryTree;
import utils.TreeNode;

public class Problem124 {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    public int maxPath(TreeNode root) {
        if (root == null) return 0;
        int leftVal = Math.max(maxPath(root.left), 0);
        int rightVal = Math.max(maxPath(root.right), 0);
        int valSingle = Math.max(leftVal, rightVal) + root.val;
        max = Math.max(valSingle, max);
        int valDouble = leftVal + rightVal + root.val;
        max = Math.max(valDouble, max);
        return valSingle;
    }

    public static void main(String[] args) {
        Problem124 p = new Problem124();
        int[] a = {5,4,8,11,0,13,4,7,2,0,0,0,1};
        BinaryTree t = new BinaryTree(a);
        BinaryTree.printNode(t.root);
        System.out.println(p.maxPathSum(t.root));
    }
}
