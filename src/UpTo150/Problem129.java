package UpTo150;

import utils.BinaryTree;
import utils.TreeNode;

public class Problem129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return (int)(sumNumbers(root.left) + sumNumbers(root.right) + base(root) * root.val);
    }

    public double base(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 10 * base(root.left) + 10 * base(root.right);
    }

    public static void main(String[] args) {
        Problem129 p = new Problem129();
        BinaryTree t = new BinaryTree(new int[]{4,9,0,5,1});
        System.out.println(p.sumNumbers(t.root));
    }
}
