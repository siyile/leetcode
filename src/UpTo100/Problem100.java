package UpTo100;

import utils.BinaryTree;
import utils.TreeNode;

public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        } else if (q == null) {
            return false;
        } else if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        Problem100 p = new Problem100();
        int[] a = {1,2,1};
        int[] b = {1,1,2};
        BinaryTree t1 = new BinaryTree(a);
        BinaryTree t2 = new BinaryTree(b);
        System.out.println(p.isSameTree(t1.root, t2.root));
    }
}
